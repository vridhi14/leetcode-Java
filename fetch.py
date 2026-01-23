const fs = require("fs");
const path = require("path");
const axios = require("axios");

const username = process.env.LEETCODE_USERNAME;
const password = process.env.LEETCODE_PASSWORD;

const loginUrl = "https://leetcode.com/accounts/login/";
const graphqlUrl = "https://leetcode.com/graphql";

const axiosInstance = axios.create({
  withCredentials: true,
  headers: {
    "User-Agent": "Mozilla/5.0",
  },
});

async function login() {
  const res = await axiosInstance.get(loginUrl);
  const csrf = res.headers["set-cookie"]
    .find((c) => c.startsWith("csrftoken"))
    .split(";")[0]
    .split("=")[1];

  await axiosInstance.post(
    loginUrl,
    new URLSearchParams({
      login: username,
      password: password,
      csrfmiddlewaretoken: csrf,
    }),
    {
      headers: {
        Referer: loginUrl,
        Cookie: `csrftoken=${csrf}`,
      },
    }
  );
}

async function fetchRecentAccepted() {
  const body = {
    query: `
      query recentAcSubmissions($username: String!) {
        recentAcSubmissionList(username: $username) {
          title
          titleSlug
          lang
        }
      }
    `,
    variables: { username },
  };

  const res = await axiosInstance.post(graphqlUrl, body, {
    headers: { Referer: "https://leetcode.com" },
  });

  return res.data.data.recentAcSubmissionList || [];
}

async function fetchCode(slug) {
  try {
    const res = await axiosInstance.get(`https://leetcode.com/problems/${slug}/submit/`);
    const html = res.data;

    const start = html.indexOf("submissionCode") + 17;
    const codeStart = html.indexOf(":", start) + 2;
    const codeEnd = html.indexOf(",\"editCodeUrl\"") - 1;

    let code = html.substring(codeStart, codeEnd);
    code = JSON.parse(`"${code}"`);
    return code;
  } catch (e) {
    return null;
  }
}

function saveCode(title, slug, lang, code) {
  // ONLY SAVE JAVA
  if (!lang.toLowerCase().includes("java")) return;

  const titleClean = title.toLowerCase().replace(/ /g, "-");

  let folder = "others";
  const t = title.toLowerCase();

  if (t.includes("list")) folder = "linked-list";
  else if (t.includes("tree")) folder = "binary-tree";
  else if (t.includes("array")) folder = "arrays";
  else if (t.includes("string")) folder = "strings";
  else if (t.includes("graph")) folder = "graphs";
  else if (t.includes("dp")) folder = "dp";

  const filePath = `${folder}/${titleClean}.java`;

  if (!fs.existsSync(folder)) fs.mkdirSync(folder);

  fs.writeFileSync(filePath, code, "utf8");
}

async function main() {
  console.log("Logging in...");
  await login();

  console.log("Fetching recent accepted submissions...");
  const subs = await fetchRecentAccepted();

  for (const sub of subs) {
    const code = await fetchCode(sub.titleSlug);
    if (!code) continue;

    saveCode(sub.title, sub.titleSlug, sub.lang, code);
  }

  console.log("Done saving Java solutions!");
}

main();
