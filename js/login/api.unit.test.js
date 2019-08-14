var fs = require("fs");
eval(fs.readFileSync("login/config.js")+"");
eval(fs.readFileSync("login/api.js")+"");

it("prompts login", async function() {
    var token = await login();
    expect(token).not.toBe(undefined);
});