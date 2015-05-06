<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
<b>JSP 방식</b>

<p><a href="/jsp/etag">etag 정적 컨텐츠 해시</a></p>
<p><a href="/jsp/etag_time_hash">etag 현재시간 컨텐츠 해시</a></p>
<p><a href="/jsp/etag_time_length">etag 현재시간 컨텐츠 길이 해시</a></p>
<p><a href="/jsp/lm">last modified date</a></p>

<b>Json 방식</b>
<p><a href="/json/etag.json">etag 정적 컨텐츠 해시</a></p>
<p><a href="/json/etag_time_hash.json">etag 현재시간 컨텐츠 해시</a></p>
<p><a href="/json/etag_time_length.json">etag 현재시간 컨텐츠 길이 해시</a></p>
<p><a href="/json/lm.json">last modified date</a></p>

<b>조건부 캐시 + 멤캐시</b>
<p><a href="/json/lyric_etag_contents_hash.json">가사 컨텐츠 해시 + 멤캐시</a></p>
<p><a href="/json/lyric_etag_contents_length.json">가사 컨텐츠 길이 해시 + 멤캐시</a></p>
<p><a href="/json/lyric_lm.json">가사 Last Modified Date + 멤캐시</a></p>
<p><a href="/json/lyric_update.json">가사 멤캐시 퍼지</a></p>

사용법 : @RequestMapping이 붙은 메소드에 아래에 어노테이션 중 하나를 넣으면 됨 <br /><br />
@MelonCache(cacheGenerator=CacheGenerator.LAST_MODIFIED_DATE)<br />
@MelonCache(cacheGenerator=CacheGenerator.ETAG_CONTENTS_HASH)<br />
@MelonCache(cacheGenerator=CacheGenerator.ETAG_CONTENTS_LENGTH)<br /><br />

@RequestMapping("/sample")<br />
@MelonCache(cacheGenerator=CacheGenerator.ETAG_CONTENTS_HASH)<br />
public String welcome(Map<String, Object> model) {<br />
&nbsp;&nbsp;&nbsp;&nbsp;model.put("time", "1234");<br />
&nbsp;&nbsp;&nbsp;&nbsp;model.put("message", "message");<br />
&nbsp;&nbsp;&nbsp;&nbsp;return "welcome";<br />
}<br /><br />

* max-age로 스톤 TTL 값을 지정할 예정
</body>

</html>
