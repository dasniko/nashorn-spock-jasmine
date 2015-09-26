require("/calculator.js");

describe("suite 1", function() {
    it("should pass", function() {
        expect(add(1, 2)).toBe(3);
    });
});

describe("suite 2", function() {
    it("should fail", function() {
        expect(add(1, 2)).toBe(3);
        expect(add(1, 2)).toBe(0);
    });
});

describe("suite 3", function() {
    xit("should be ignored", function() {
        expect(add(1, 2)).toBe(3);
    });
});