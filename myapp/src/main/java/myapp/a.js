
    function b(m) {
        for (; d < a.length;) {
            var n = a.charAt(d++),
                p = $f[n];
            if (null != p) return p;
            if (!/^[\s\xa0]*$/.test(n)) throw Error("Unknown base64 encoding at char: " + n);
        }
        return m
    }
    Yf = Yf || Zf();
    $f = $f || Xf();
        for (var c = "", d = 0;;) {
            var e = b(-1),
                f = b(0),
                g = b(64),
                l = b(64);
            if (64 === l && -1 === e) return c;
            c += String.fromCharCode(e << 2 | f >> 4);
            64 != g && (c += String.fromCharCode(f << 4 & 240 | g >> 2), 64 != l && (c += String.fromCharCode(g << 6 & 192 | l)))
        }

var bg;
var fg = function () {
        var a = cg,
            b = dg,
            c = eg(),
            d = function (g) {
                a(g.target || g.srcElement || {})
            },
            e = function (g) {
                b(g.target || g.srcElement || {})
            }