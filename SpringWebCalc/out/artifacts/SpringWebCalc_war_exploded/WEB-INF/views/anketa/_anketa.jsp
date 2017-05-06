<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Gallery</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="<c:url value="/resources/css/reset.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/superfish.css" />" rel="stylesheet">
    <!--[if IE]><link rel="stylesheet" type="text/css" media="screen,projection" href="<c:url value="/resources/css/ie6.css" />" /><![endif]-->
    <script type="text/javascript" src="<c:url value="/resources/js/jquery-1.4.2.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/calend.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/superfish.js" />" ></script>
    <script type="text/javascript" src="<c:url value="/resources/js/script.js" />" ></script>
</head>
<body>
<div class="ambitios_main" id="options-examples">
    <!-- Header -->
    <div class="ambitios_header_tile_left"></div>
    <div class="ambitios_header_tile_right"></div>
    <div class="ambitios_row_tile_sub"></div>
    <div class="ambitios_row_tile_sub_right"></div>
    <div class="ambitios_header">

        <div class="ambitios_head">

            <!-- logo -->
            <a href="/" class="ambitios_logo"> <img src="<c:url value="/resources/images/ambitios_logo.png" />" alt="" /> </a>
            <!-- EOF logo -->
            <!-- menu -->

            <ul class="ambitios_menu">
                <li><a href="#" class=""> <span><span>Home</span></span></a></li>
                <li><a href="#" class=""> <span><span>Upload</span></span></a></li>
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

                <div class="ambitios_grid_8">
                    We are going to prepare a lot of tasty features for you. <br />

                    So stay tuned!
                </div>

            </div>

        </div>

    </div>

    <!-- EOF Header -->
    <!-- Content -->

    <!-- EOF Header -->
    <!-- Content -->
    <div class="ambitios_content">
        <div class="ambitios_container_16">
            <div class="ambitios_wrapper">
                <div class="ambitios_grid_11 ambitios_alpha">
                    <div>
                        <jsp:include page="allanketa.jsp"></jsp:include>
                    </div>
                </div>
                <div class="ambitios_grid_5 ambitios_omega">
                    <div class="ambitios_indent">
                        <h3 class="ambitios_uppercase">Наши преимущества</h3>
                    </div>
                    <ul class="ambitios_link_list ambitios_p2">
                        <li><a href="#">Актуальные цены</a></li>
                        <li><a href="#">Современное оборудование</a></li>
                        <li><a href="#">Производительность и надежность</a></li>
                        <li><a href="#">Высокий показатель качества</a></li>
                        <li><a href="#">Оперативное обслуживание</a></li>
                        <li><a href="#">Широкий выбор</a></li>
                        <li><a href="#">Гибкий подход</a></li>
                    </ul>
                    <div class="ambitios_title">
                        <div class="ambitios_title_left">
                            <div class="ambitios_title_right">
                                <div class="ambitios_title_shape ambitios_2rows">
                                    Новые технологии вакуумной техники
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="ambitios_txt_block ambitios_height">
                        <div class="ambitios_wrapper ambitios_p2">
                                    <span class="ambitios_picture ambitios_fleft">
                                        <img src="<c:url value="/resources/images/tech1.jpg" />" alt="" />
                                    </span>
                        </div>
                        <p class="center">По вашему техническому заданию мы можем разработать и передать технологию нанесения покрытий с изготовлением оборудования. </p>
                    </div>
                    <div class="ambitios_indent">
                        <div class="ambitios_comments">
                            <p id="calendp"></p>
                            <table id="calend"></table>
                        </div>
                    </div>
                </div>
            </div>
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
                        <div class="ambitios_footer_widget"> Additional area </div>
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