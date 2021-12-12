<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
<script>$("#farmer-vid")[1].play()</script>
</head>
<body>
<%--<div style="background-color: #DD4A48; text-align: center">&lt;%&ndash;add this to style.css&ndash;%&gt;</div>--%>
<div id="home">
    <jsp:include page="/WEB-INF/partials/navbar.jsp"/>
    <div class="d-flex align-items-center h-50">
        <img id="howdy-img" src="https://bit.ly/3GD5edE" alt="Welcome to Fresh Feed">
    </div>
    <div class="d-flex justify-content-between" id="home-ads">
        <div>
            <h1>Here Are all the ads!</h1>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aliquid consequuntur explicabo iure, obcaecati perferendis sint voluptatum. Aspernatur dolorum exercitationem facere rerum. Sed, suscipit ullam? Dolorem eos excepturi inventore ipsam iure nam officiis, rerum temporibus. Ad, aliquam aperiam atque consequuntur culpa dolorem doloremque dolores eveniet facere mollitia, natus nihil, obcaecati pariatur perferendis placeat porro quae quas quo repellendus repudiandae rerum saepe sit vero. Ab, aliquam amet aperiam beatae consequatur delectus deserunt dicta dolor eaque eligendi, enim est fugiat impedit in incidunt itaque labore, maxime non odit officia omnis pariatur perspiciatis porro quo reiciendis repudiandae sint sit suscipit tempora tempore unde voluptate?</p>
            <c:forEach var="ad" items="${ads}">
                <div class="col-md-4">
                    <h2>${ad.title}</h2>
                    <p>${ad.description}</p>
                    <p>$${ad.price}</p>
                    <form action="/ad" method="get">
                        <button>Click for Details</button>
                        <input type="hidden" name="ad" value="${ad.id}">
                    </form>
                </div>
            </c:forEach>
            <hr>
            <h1>Another section with stuff in it!</h1>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet blanditiis delectus dolore doloremque, ea enim error et excepturi in itaque magni, necessitatibus quas soluta sunt unde. Aliquid autem consectetur, debitis eos fuga molestiae nesciunt non odit perspiciatis quaerat, recusandae similique sunt veritatis voluptatibus voluptatum. Cum dolores esse pariatur quibusdam voluptates.</p>
        </div>
        <div class="">
            <h3>Yet another section!</h3>
            <img src="https://www.fillmurray.com/640/360">
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Autem dignissimos eaque est ipsa labore laudantium molestias quaerat quasi rerum unde!</p>
        </div>
    </div>
    <jsp:include page="/WEB-INF/partials/footer.jsp"/>
</div>
<video class="w-100" autoplay loop muted id="farmer-vid" src="pexels-rodnae-productions-8540430.mp4"></video>

</body>
</html>