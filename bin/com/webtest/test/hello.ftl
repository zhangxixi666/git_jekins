<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome!</title>
</head>
<body>
<#--ע�Ͳ���-->
<#--����ʹ�ò�ֵ-->
<h1>Welcome ${user}!</h1>
<p>We have these animals:</p>
<ul>
<#--ʹ�ãƣԣ�ָ��-->
<#list animals?sort_by("price")?reverse as being>
   <li>${being_index} ${being.name} for ${being.price} Euros</li>
</#list>
</ul>

<#if (score==10)>
    abcdefg
</#if><br/>
  
${(team?split(","))[1]}<br/>

<#list sexMap?keys as k>
   ${k}---${sexMap[k]}<br/>
</#list>
</body>
</html>