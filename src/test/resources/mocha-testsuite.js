//var fut = require('./calculator.js').calc;
loadJS('/calculator.js');

describe('Addition', function() {
    it('should be 3', function() {
        assert.equal(3, add(1, 2));
    });
});
