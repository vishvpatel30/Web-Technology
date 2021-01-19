
<html>
<body>


<button onclick="myFunction()">Button</button>

<p id="demo"></p>

<script>
function myFunction() {
  var str = "Hello World!";
  var x=str.split(" ");
  var str=x[0]+" vishv";
  var result = str.fontcolor("yellow");
  document.getElementById("demo").innerHTML = result;
  document.body.style.background = "blue";
}
</script>

</body>
</html>
