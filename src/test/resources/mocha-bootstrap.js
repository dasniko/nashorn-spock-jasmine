var loadJS = function(path) {
  load(Java.type("dasniko.spock.nashorn.MochaSpec").class.getResource(path).toExternalForm());
};

//loadJS('/jvm-npm.js');
loadJS('/nashorn-polyfill.js');
loadJS('/mocha/mocha.js');

mocha.setup({
    reporter: 'json'
});

//mocha.addFile('mocha-testsuite.js');
loadJS('/mocha-testsuite.js');

mocha.run();
