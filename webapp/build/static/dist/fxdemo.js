/******/ (function(modules) { // webpackBootstrap
/******/ 	// The module cache
/******/ 	var installedModules = {};
/******/
/******/ 	// The require function
/******/ 	function __webpack_require__(moduleId) {
/******/
/******/ 		// Check if module is in cache
/******/ 		if(installedModules[moduleId]) {
/******/ 			return installedModules[moduleId].exports;
/******/ 		}
/******/ 		// Create a new module (and put it into the cache)
/******/ 		var module = installedModules[moduleId] = {
/******/ 			i: moduleId,
/******/ 			l: false,
/******/ 			exports: {}
/******/ 		};
/******/
/******/ 		// Execute the module function
/******/ 		modules[moduleId].call(module.exports, module, module.exports, __webpack_require__);
/******/
/******/ 		// Flag the module as loaded
/******/ 		module.l = true;
/******/
/******/ 		// Return the exports of the module
/******/ 		return module.exports;
/******/ 	}
/******/
/******/
/******/ 	// expose the modules object (__webpack_modules__)
/******/ 	__webpack_require__.m = modules;
/******/
/******/ 	// expose the module cache
/******/ 	__webpack_require__.c = installedModules;
/******/
/******/ 	// define getter function for harmony exports
/******/ 	__webpack_require__.d = function(exports, name, getter) {
/******/ 		if(!__webpack_require__.o(exports, name)) {
/******/ 			Object.defineProperty(exports, name, {
/******/ 				configurable: false,
/******/ 				enumerable: true,
/******/ 				get: getter
/******/ 			});
/******/ 		}
/******/ 	};
/******/
/******/ 	// getDefaultExport function for compatibility with non-harmony modules
/******/ 	__webpack_require__.n = function(module) {
/******/ 		var getter = module && module.__esModule ?
/******/ 			function getDefault() { return module['default']; } :
/******/ 			function getModuleExports() { return module; };
/******/ 		__webpack_require__.d(getter, 'a', getter);
/******/ 		return getter;
/******/ 	};
/******/
/******/ 	// Object.prototype.hasOwnProperty.call
/******/ 	__webpack_require__.o = function(object, property) { return Object.prototype.hasOwnProperty.call(object, property); };
/******/
/******/ 	// __webpack_public_path__
/******/ 	__webpack_require__.p = "";
/******/
/******/ 	// Load entry module and return exports
/******/ 	return __webpack_require__(__webpack_require__.s = 81);
/******/ })
/************************************************************************/
/******/ ({

/***/ 0:
/***/ (function(module, exports) {

module.exports = React;

/***/ }),

/***/ 10:
/***/ (function(module, exports) {

module.exports = ReactDOM;

/***/ }),

/***/ 32:
/***/ (function(module, exports, __webpack_require__) {

"use strict";


Object.defineProperty(exports, "__esModule", {
  value: true
});

var _MyFetch = __webpack_require__(33);

var _MyFetch2 = _interopRequireDefault(_MyFetch);

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

exports.default = { MyFetch: _MyFetch2.default };

/***/ }),

/***/ 33:
/***/ (function(module, exports, __webpack_require__) {

"use strict";


Object.defineProperty(exports, "__esModule", {
    value: true
});
exports.default = {
    fetch: function (_fetch) {
        function fetch(_x, _x2, _x3) {
            return _fetch.apply(this, arguments);
        }

        fetch.toString = function () {
            return _fetch.toString();
        };

        return fetch;
    }(function (url, _opt, _then) {
        _opt.headers = {
            "Content-Type": "application/x-www-form-urlencoded"
        };

        fetch(url, _opt).then(function (response) {
            //ok status 200-299  
            if (response.ok) {
                response.json().then(function (data) {
                    if (_then) {
                        _then(data);
                    }
                });
            } else {
                throw new Error(response.statusText);
            }
        }).catch(function (err) {
            console.warn(err);
        });
    })
};

/***/ }),

/***/ 81:
/***/ (function(module, exports, __webpack_require__) {

"use strict";


var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

var _react = __webpack_require__(0);

var _react2 = _interopRequireDefault(_react);

var _reactDom = __webpack_require__(10);

var _reactDom2 = _interopRequireDefault(_reactDom);

var _index = __webpack_require__(32);

var _index2 = _interopRequireDefault(_index);

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }

function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }

var FxDemo = function (_React$Component) {
    _inherits(FxDemo, _React$Component);

    function FxDemo(props) {
        _classCallCheck(this, FxDemo);

        return _possibleConstructorReturn(this, (FxDemo.__proto__ || Object.getPrototypeOf(FxDemo)).call(this, props));
    }

    _createClass(FxDemo, [{
        key: 'componentWillMount',
        value: function componentWillMount() {
            console.log('Common', _index2.default);

            MyFetch.fetch('http://localhost/test.json', { method: 'GET' }, function (json) {
                console.log(json);
            });
        }
    }, {
        key: 'render',
        value: function render() {
            var _this2 = this;

            return _react2.default.createElement(
                'div',
                { className: 'block block-themed animated bounceIn' },
                _react2.default.createElement(
                    'div',
                    { className: 'block-content block-content-full block-content-narrow' },
                    _react2.default.createElement(
                        'h1',
                        { className: 'h2 font-w600 push-5' },
                        'RodinX1'
                    ),
                    _react2.default.createElement(
                        'p',
                        null,
                        'Please enter the password.'
                    ),
                    _react2.default.createElement(
                        'div',
                        { className: 'row push-50-t' },
                        _react2.default.createElement(
                            'div',
                            { className: 'col-xs-12' },
                            _react2.default.createElement(
                                'div',
                                { className: 'form-material form-material-primary' },
                                _react2.default.createElement('input', { ref: function ref(_ref) {
                                        return _this2.inputPassword = _ref;
                                    }, className: 'form-control', type: 'password', placeholder: 'Enter the admin password..' }),
                                _react2.default.createElement(
                                    'label',
                                    { 'for': 'register-password' },
                                    'Password'
                                ),
                                _react2.default.createElement(
                                    'button',
                                    { className: 'btn btn-square btn-primary', onClick: _java_alert },
                                    _react2.default.createElement('i', { className: 'glyphicon glyphicon-cog' }),
                                    ' java call js'
                                ),
                                _react2.default.createElement(
                                    'button',
                                    { className: 'btn btn-square btn-primary', onClick: _app_instance_app_exit },
                                    _react2.default.createElement('i', { className: 'glyphicon glyphicon-cog' }),
                                    ' js call java'
                                )
                            )
                        )
                    )
                )
            );
        }
    }]);

    return FxDemo;
}(_react2.default.Component);

_reactDom2.default.render(_react2.default.createElement(FxDemo, null), document.body);

/***/ })

/******/ });
//# sourceMappingURL=fxdemo.js.map