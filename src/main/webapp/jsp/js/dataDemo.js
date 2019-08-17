function ArrayUtils() {
    this.search = function (arr, str) {
        return arr.indexOf(str);
    }
}

String.prototype.a = function () {
    // alert("al"+this.length);
};

String.prototype.res = function (char) {
    var chars = [];
    for (var i = 0; i < this.length; i++) {
        chars[i] = this.charAt(i);
    }
    chars.reverse();
    var s = chars.join('');
    alert(s);

};

function test0() {
    alert("aaaaaaa");
}

window.onload = function () {
    function change() {
        var p = document.getElementById("p");
        p.innerHTML = new Date();
    }

    window.setInterval(change, 1000);
    var a = document.getElementById("a");
    var arrS0 = ["1", 2, 3, 4];
    var arrayU = new ArrayUtils();
    var i = arrayU.search(arrS0, 4);
    a.innerHTML = i;
    // alert(i);

    var aaa = "aaa";
    aaa.a();


    var ii = document.getElementById("ii");
    ii.onclick = function () {
        window.open("../eeee.html", "_self");

    };
};




