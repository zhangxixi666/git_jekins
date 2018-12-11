<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome!</title>
</head>
<body>
<#--注释部分-->
<#--下面使用插值-->
<h1>Welcome ${user}!</h1>
<p>Our latest product:</p>
<#list latestProduct as k>
	<a href="${k.url}">${k.name}</a>
</#list>
</body>
</html>