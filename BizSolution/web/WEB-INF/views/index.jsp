<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>BizSolution</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link href="<c:url value="/resources/css/reset.css" />" rel="stylesheet" type="text/css">
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" type="text/css">
    <link href="<c:url value="/resources/css/prettyPhoto.css" />" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="<c:url value="/resources/js/jquery-1.3.2.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/script.js" />" ></script>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery.js" />" ></script>
    <script type="text/javascript" src="<c:url value="/resources/js/project_carousel.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/main.js" />" ></script>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery.prettyPhoto.js" />" ></script>
    <script type="text/javascript" src="<c:url value="/resources/js/popups.js" />" ></script>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery.tools.min.js" />" ></script>
</head>
<body>
<div class="line">
    <div class="block_top_text">
        <p>Number one in business</p>
    </div>
    <div class="block_top_lnks">
        <ul>
            <li>
                <a href="#sign_popup" name="sign_pop" rel="prettyPhoto[gallery0]">Sign in</a>
            </li>
            <li>
                <a href="#reg_popup" name="reg_pop" rel="prettyPhoto[gallery00]">Registration</a>
            </li>
        </ul>
    </div>
    <div class="clr"></div>
</div>
<div class="main">
    <div class="header">
        <div class="logo">
            <h1><a href="/"><span>biz</span> solution<small>Simple web template</small></a></h1>
        </div>
        <div class="menu_nav">
            <ul>
                <li><a href="/">Home</a></li>
                <li><a href="/support">Support</a></li>
                <li><a href="/about">About Us</a></li>
                <li><a href="/blog">Blog</a></li>
                <li><a href="/contact">Contact Us</a></li>
            </ul>
            <div class="clr"></div>
        </div>
        <div class="clr"></div>
        <div class="hbg">
            <img src="<c:url value="/resources/images/header_images.jpg" />" alt="" />
            <div class="text">
                <h3>Creating Futures</h3>
            </div>
        </div>
    </div>
    <div class="content">
        <div class="content_bg">
            <div class="mainbar">
                <jsp:include page="${template}.jsp"></jsp:include>
            </div>
            <div class="sidebar">
                <div class="gadget">
                    <div class="search">
                        <form method="get" id="search" action="">
                              <span>
                              <input type="text" value="Search..." name="s" id="s" />
                              <input name="searchsubmit" type="image" src="<c:url value="/resources/images/search.gif" />" value="Go" id="searchsubmit" class="btn"  />
                              </span>
                        </form>
                        <!--/searchform -->
                        <div class="clr"></div>
                    </div>
                    <div class="clr"></div>
                </div>
                <div class="gadget">
                    <h2><span>Sidebar</span> Menu</h2>
                    <div class="clr"></div>
                    <ul class="sb_menu">
                        <li class="active"><a href="#">Home</a></li>
                        <li><a href="#">TemplateInfo</a></li>
                        <li><a href="#">Style Demo</a></li>
                        <li><a href="#">Blog</a></li>
                        <li><a href="#">Archives</a></li>
                        <li><a href="http://www.dreamtemplate.com" title="Website Templates">Web Templates</a></li>
                    </ul>
                </div>
                <div class="gadget">
                    <h2><span>Sponsors</span></h2>
                    <div class="clr"></div>
                    <ul class="ex_menu">
                        <li class="active"><a href="http://www.dreamtemplate.com" title="Website Templates">DreamTemplate</a> <span>Over 6,000+ Premium Web Templates</span></li>
                        <li><a href="http://www.templatesold.com" title="WordPress Themes">TemplateSOLD</a> <span>Premium WordPress &amp; Joomla Themes</span></li>
                        <li><a href="http://www.imhosted.com" title="Affordable Hosting">ImHosted.com</a> <span>Affordable Web Hosting Provider</span></li>
                        <li><a href="http://www.dreamstock.com/">DreamStock</a> <span>Unlimited Amazing Stock Photos</span></li>
                        <li><a href="http://www.evrsoft.com" title="Website Builder">Evrsoft</a> <span>Website Builder Software &amp; Tools</span></li>
                        <li><a href="http://www.csshub.com/" title="CSS Templates">CSS Hub</a> <span>Premium CSS Templates</span></li>
                    </ul>
                </div>
                <div class="gadget">
                    <h2 class="grey"><span>Wise Words</span></h2>
                    <div class="clr"></div>
                    <div class="testi">
                        <p><span class="q">ret</span> We can let circumstances rule us, or we can take charge and rule our lives from within. <span class="q">кен</span></p>
                        <p class="title"><strong>Earl Nightingale</strong></p>
                    </div>
                </div>
            </div>
            <div class="clr"></div>
        </div>
    </div>
    <div class="fbg">
        <div class="col c1">
            <h2><span>Image Gallery</span></h2>
            <a href="#"><img src="<c:url value="/resources/images/pic_1.jpg" />" width="58" height="58" alt="pix" /></a> <a href="#"><img src="<c:url value="/resources/images/pic_2.jpg" />" width="58" height="58" alt="pix" /></a> <a href="#"><img src="<c:url value="/resources/images/pic_3.jpg" />" width="58" height="58" alt="pix" /></a> <a href="#"><img src="<c:url value="/resources/images/pic_4.jpg" />" width="58" height="58" alt="pix" /></a> <a href="#"><img src="<c:url value="/resources/images/pic_5.jpg" />" width="58" height="58" alt="pix" /></a> <a href="#"><img src="<c:url value="/resources/images/pic_6.jpg" />" width="58" height="58" alt="pix" /></a> </div>
        <div class="col c2">
            <h2><span>Lorem Ipsum</span></h2>
            <p>Lorem ipsum dolor<br />
                Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Donec libero. Suspendisse bibendum. Cras id urna. <a href="#">Morbi tincidunt, orci ac convallis aliquam</a>, lectus turpis varius lorem, eu posuere nunc justo tempus leo. Donec mattis, purus nec placerat bibendum, dui pede condimentum odio, ac blandit ante orci ut diam.</p>
        </div>
        <div class="col c3">
            <h2><span>About</span></h2>
            <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Donec libero. Suspendisse bibendum. Cras id urna. Morbi tincidunt, orci ac convallis aliquam, lectus turpis varius lorem, eu posuere nunc justo tempus leo. llorem, eu posuere nunc justo tempus leo. Donec mattis, purus nec placerat bibendum. <a href="#">Learn more...</a></p>
        </div>
        <div class="clr"></div>
    </div>
    <div class="footer">
        <div class="footer_resize">
            <p class="lf">© Copyright <a href="#">MyWebSite</a>.</p>
            <p class="rf">Layout by Cool <a href="http://www.coolwebtemplates.net/">Website Templates</a></p>

            <div class="clr"></div>
        </div>
    </div>
</div>

<!-- sign form -->
<div class="disp_none">
    <div id="reg_popup">
        <div class="sign_popup">
            <h2>Registration</h2>
            <h3>Register in to your account</h3>
            <form action="" method="post" id="f_sign">
                <div class="inp_line">
                    <label>Login:</label>
                    <div class="field"><input type="text" class="w_focus" name="name" /></div>
                </div>
                <div class="inp_line">
                    <label>E-mail:</label>
                    <div class="field"><input type="text" class="w_focus" name="email" /></div>
                    <input type="button" name="ds" id="test" value="test">
                </div>
                <div class="inp_line">
                    <label>Password:</label>
                    <div class="field"><input type="text" class="w_focus" name="password" /></div>
                </div>
                <div class="inp_checkbox">
                    <a id="singIn" href="javascript:void(0);" class="button_lnk blue fl def_link"><span>Register</span></a>
                </div>
            </form>
        </div>
    </div>

    <div id="sign_popup">
        <div class="sign_popup">
            <h2>Authorization on the site</h2>
            <h3>Sign in to your account</h3>
            <form action="" method="post" id="f_sign2">
                <div class="inp_line">
                    <label>Login:</label>
                    <div class="field"><input  type="text" class="w_focus" name="name" /></div>

                </div>
                <div class="inp_line">
                    <label>Password:</label>
                    <div class="field"><input type="text" class="w_focus" name="password" /></div>
                </div>
                <div class="clr"></div>
                <div class="inp_checkbox">
                    <div class="inp_checkbox_in"><a href="#">Forgot your password?</a></div>
                    <a id="reg" href="javascript:void(0);" class="button_lnk blue fl def_link"><span>Sign In</span></a>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>