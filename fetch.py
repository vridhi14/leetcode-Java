import requests
import json
import os
from datetime import datetime

LEETCODE_USERNAME = os.getenv("LEETCODE_USERNAME")
LEETCODE_PASSWORD = os.getenv("LEETCODE_PASSWORD")

login_url = "https://leetcode.com/accounts/login/"
graphql_url = "https://leetcode.com/graphql"

session = requests.Session()

# ------------------ LOGIN ------------------
def leetcode_login():
    session.get(login_url)
    csrftoken = session.cookies["csrftoken"]

    payload = {
        "login": LEETCODE_USERNAME,
        "password": LEETCODE_PASSWORD,
        "csrfmiddlewaretoken": csrftoken
    }

    session.post(login_url, data=payload, headers={"Referer": login_url})

# ------------------ FETCH SUBMISSIONS ------------------
def fetch_submissions():
    query = {
        "query": """
            query recentAcSubmissions($username: String!) {
                recentAcSubmissionList(username: $username) {
                    titleSlug
                    title
                    lang
                }
            }
        """,
        "variables": {
            "username": LEETCODE_USERNAME
        }
    }

    res = session.post(graphql_url, json=query, headers={"Referer": "https://leetcode.com"})
    data = res.json()

    return data["data"]["recentAcSubmissionList"]

# ------------------ FETCH CODE FOR EACH PROBLEM ------------------
def fetch_submission_code(slug):
    url = f"https://leetcode.com/problems/{slug}/submit/"
    res = session.get(url)

    if "submissionCode" not in res.text:
        return None

    try:
        start = res.text.index("submissionCode") + 17
        start = res.text.index(":", start) + 2
        end = res.text.index(",\"editCodeUrl\"") - 1
        code = res.text[start:end].encode("utf-8").decode("unicode_escape")
        return code
    except:
        return None

# ------------------ SAVE CODE TO FOLDERS ------------------
def save_code(title, slug, lang, code):
    folder = ""

    title_clean = title.lower().replace(" ", "-")

    if "list" in title.lower():
        folder = "linked-list"
    elif "array" in title.lower():
        folder = "arrays"
    elif "string" in title.lower():
        folder = "strings"
    elif "tree" in title.lower():
        folder = "binary-tree"
    elif "dp" in title.lower():
        folder = "dp"
    elif "graph" in title.lower():
        folder = "graphs"
    else:
        folder = "others"

    ext = "java" if "java" in lang.lower() else "py"

    file_path = f"{folder}/{title_clean}.{ext}"

    os.makedirs(folder, exist_ok=True)

    with open(file_path, "w", encoding="utf-8") as f:
        f.write(code)

# ------------------ MAIN ------------------
def main():
    print("Logging into LeetCode...")
    leetcode_login()

    print("Fetching submissions...")
    subs = fetch_submissions()

    for sub in subs:
        code = fetch_submission_code(sub["titleSlug"])
        if not code:
            continue

        save_code(sub["title"], sub["titleSlug"], sub["lang"], code)

    print("Done saving all accepted submissions.")

if __name__ == "__main__":
    main()
