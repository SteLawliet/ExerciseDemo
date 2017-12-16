for (var i = 0; i < 5; i++) {
    for (var j = 0; j < i + 1; j++) {
        document.write("@" + "&nbsp");
    }
    document.write("<br>");
}
document.write("<hr>");

for (var i = 1; i <= 9; i++) {
    for (var j = 1; j <= i; j++) {
        document.write(j + "*" + i + "=" + i * j + "&nbsp;&nbsp;");
    }
    document.write("<br>");
}