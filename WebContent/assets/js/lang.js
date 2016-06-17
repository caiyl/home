/**
 * 类继承
 */

var lang = {
	/**
	 * FROM: yahoo yui
	 */
	extend : function(subclass, superclass) {
		superclass = processSuperclass(superclass);
		var f = function() {};
		f.prototype = superclass.prototype;
		subclass.prototype = new f();
		subclass.prototype.constructor = subclass;
		subclass.superclass = superclass.prototype;
		if (superclass.prototype.constructor == Object.prototype.constructor) {
			superclass.prototype.constructor = superclass;
		}
	},
		
	/**
	 * FROM: json.org,json.js
	 */
	parseJSON : function (jsonString) { 
		return eval('(' + jsonString + ')');
	},
	
	/**
	 * FROM: json.org,json.js
	 */
	toJSONString : function (obj) { 
		var m = {	'\b': '\\b',
							'\t': '\\t',
							'\n': '\\n',
							'\f': '\\f',
							'\r': '\\r',
							'"' : '\\"',
							'\\': '\\\\'	};
		var s = {
			array: function (x) {
				var a = ['['], b, f, i, l = x.length, v;
				if(l == 0) {
					var isNull = true;
					for(var i in x) {
						// webos's code begin
						if ( i == "remove" || i == "indexOf" ) {
							delete x[i];
							continue;
						}
						if( x.toJSON)
							return x.toJSON();
						// webos's code end
						isNull = false;
						break;
					}
					if(!isNull) {
						var a = ['{'], b, f, i, v;
						for (i in x) {
							v = x[i];
								f = s[typeof v];
								if (f) {
									v = f(v);
									if (typeof v == 'string') {
										if (b) {
											a[a.length] = ',';
										}
										a.push(s.string(i), ':', v);
										b = true;
									}
								}
							}
						a[a.length] = '}';
						return a.join('');
					}
				} else {
					for (i = 0; i < l; i += 1) {
						v = x[i];
						f = s[typeof v];
						if (f) {
							v = f(v);
							if (typeof v == 'string') {
								if (b) {
									a[a.length] = ',';
								}
								a[a.length] = v;
								b = true;
							}
						}
					}
				}
				a[a.length] = ']';
				return a.join('');
			},
			'boolean': function (x) {
				return String(x);
			},
			'null': function (x) {
				return "null";
			},
			number: function (x) {
				return isFinite(x) ? String(x) : 'null';
			},
			object: function (x) {
				if (x) {
					if (x instanceof Array) {
						return s.array(x);
					}
					var a = ['{'], b, f, i, v;
					for (i in x) {
						v = x[i];
							f = s[typeof v];
							if (f) {
								v = f(v);
								if (typeof v == 'string') {
									if (b) {
										a[a.length] = ',';
									}
									a.push(s.string(i), ':', v);
									b = true;
								}
							}
						}
					a[a.length] = '}';
					return a.join('');
				}
				return 'null';
			},
			string: function (x) {
				if (/["\\\x00-\x1f]/.test(x)) {
					x = x.replace(/([\x00-\x1f\\"])/g, function(a, b) {
							var c = m[b];
							if (c) {
								return c;
							}
							c = b.charCodeAt();
							return '\\u00' + Math.floor(c / 16).toString(16) + (c % 16).toString(16);
					});
				}
        		return '"' + x + '"';
			}
		};
		return s[typeof obj](obj);
	}
};

var processSuperclass = function(superclass) {
	if ( "string" == typeof superclass ) {
		superclass = jsloader.resolve(superclass);
	} else {
		;
	}
	return superclass;
};
