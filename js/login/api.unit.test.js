eval(require("fs").readFileSync("login/api.js")+"");

it("prompts login", function() {
    try {
        var token = await login();
        expect(token).not.toBe(undefined);
    }
});