eval(require("fs").readFileSync("login/api.js")+"");

it("prompts login", function() {
    try {
        await login();
    }
});