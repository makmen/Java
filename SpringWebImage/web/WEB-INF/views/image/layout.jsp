<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Gallery</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/reset.css" />" />
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/main.css" />" />
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/color.css" />" />
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/prettyPhoto.css" />" />
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/superfish.css" />"  media="all" />
    <!--[if IE]><link rel="stylesheet" type="text/css" media="screen,projection" href="<c:url value="/resources/css/ie6.css" />" /><![endif]-->
    <script type="text/javascript" src="<c:url value="/resources/js/jquery-1.3.2.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/cufon-yui.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/cufon-replace.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/Quicksand_Bold_700.font.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/Quicksand_Book_400.font.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery.scrollTo-min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery.prettyPhoto.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery.infinitecarousel.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/superfish.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/hoverIntent.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery.validate.pack.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/script.js" />"></script>
</head>
<body>
    <div class="ambitios_main" id="options-examples"  >

        <!-- Header -->

        <div class="ambitios_header_tile_left"></div>
        <div class="ambitios_header_tile_right"></div>
        <div class="ambitios_row_tile_sub"></div>
        <div class="ambitios_row_tile_sub_right"></div>
        <div class="ambitios_header">

            <div class="ambitios_head">

                <!-- logo -->
                <a href="index.html" class="ambitios_logo"><img src="<c:url value="/resources/images/ambitios_logo.png" />" alt="" /></a>
                <!-- EOF logo -->

                <!-- menu -->
                <ul class="ambitios_menu">
                    <li><a href="<c:url value="/" />" class="ambitios_active"><span><span>Home</span></span></a></li>
                    <li><a href="<c:url value="/upload" />"><span><span>Upload</span></span></a></li>
                </ul>
                <!-- EOF menu -->

            </div>

        </div>

        <div class="ambitios_rows_sub">

            <div class="ambitios_container_16">

                <div class="ambitios_wrapper">

                    <div class="ambitios_grid_8 ambitios_alpha">

                        <h1 class="ambitios_uppercase">Theme features</h1>

                    </div>

                    <div class="ambitios_grid_8"> We are going to prepare a lot of tasty features for you. <br/>

                        So stay tuned! </div>

                </div>

            </div>

        </div>

        <!-- EOF Header -->

        <!-- Content -->

        <div class="ambitios_content">
            <div class="ambitios_container_16">
                <jsp:include page="${template}"></jsp:include>
            </div>
        </div>

        <!-- EOF Content -->

        <!-- Row top -->

        <div class="ambitios_row_top">

            <div class="ambitios_container_16" id="toc"> <a href="#top" id="top-link">to top</a> </div>

        </div>

        <!-- EOF Row top -->

        <!-- Row second -->
        <div class="ambitios_row2_bg_g">
            <div class="ambitios_row2_bg_g_left"></div>
            <div class="ambitios_row2_bg_g_right"></div>
            <div class="ambitios_row2_bg">
                <div class="ambitios_container_16">
                    <div class="ambitios_wrapper">
                        <div class="ambitios_left">
                            <!-- footer_widget -->
                            <div class="ambitios_footer_widget"> Additional footer advert area </div>
                            <!-- EOF footer_widget -->
                        </div>
                        <div class="ambitios_right">
                            <!-- footer_widge text -->
                            <div class="ambitios_text"> This is something your client can't miss. You can add text images, tweets or news here. But of course you can hide this area, If you want, and make footer smaller. Lorem ipsum dolor sit amet, consectetur adipi- scing elit. Vivamus condimentum, massa eu accumsan pellentesque, felis metus imperdiet est, aliquam </div>
                            <!-- EOF footer_widget text -->
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- EOF Row second -->
        <!-- EOF footer text --> <!-- Footer -->
        <div class="ambitios_footer_tile_g_left"></div>
        <div class="ambitios_footer_tile_g_right"></div>
        <div class="ambitios_footer">
            <div class="ambitios_container_16">
                <div class="ambitios_copy"> &copy; 2010 ambitious. All rights reserved. </div>
            </div>
        </div>
        <!-- EOF Footer -->

    </div>
</body>
</html>