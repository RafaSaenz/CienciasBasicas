<%-- 
    Document   : home.jsp
    Created on : 2/11/2017, 09:10:26 AM
    Author     : gerardodm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <jsp:include page="head.html" flush="true"></jsp:include>

    <body>
        <div class="wapper">
            <div id="loader-wrapper">
                <div id="loader"></div>
                <div class="loader-section section-left"></div>
                <div class="loader-section section-right"></div>
            </div>
            <jsp:include page="quicknav-2.jsp" flush="true"></jsp:include>
            <header id="header" class="style2">
                <jsp:include page="navbar.jsp" flush="true"></jsp:include>
            </header>
            <section class="banner style2">
                <div class="left-slider">
                    <div class="item">
                        <img src="images/banner/index2-sliderImg1.jpg" alt="">
                        <div class="slide-info">
                            <h2>Education Needs  Complete Solution</h2>
                            <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
                        </div>
                    </div>
                    <div class="item">
                        <img src="images/banner/index2-sliderImg2.jpg" alt="">
                        <div class="slide-info">
                            <h2>Education Needs  Complete Solution</h2>
                            <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
                        </div>
                    </div>
                    <div class="item">
                        <img src="images/banner/index2-sliderImg3.jpg" alt="">
                        <div class="slide-info">
                            <h2>Education Needs  Complete Solution</h2>
                            <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
                        </div>
                    </div>
                </div>
                <div class="info-form">
                    <h2>Request More Information</h2>
                    <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy type specimen book.</p>
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="select-box">
                                <select class="degree-select">
                                    <option>Degree</option>
                                    <option>B.C.A</option>
                                    <option>M.C.A</option>
                                    <option>B.E</option>
                                </select>
                            </div>
                        </div>
                        <div class="col-sm-12">
                            <div class="select-box">
                                <select class="area-select">
                                    <option>Area of study</option>
                                    <option>American Studies</option>
                                    <option>Anthropology</option>
                                    <option>Arabic Studies</option>
                                </select>
                            </div>
                        </div>
                        <div class="col-sm-12">
                            <div class="select-box">
                                <select class="specialization-select">
                                    <option>Specialization</option>
                                    <option>American Studies</option>
                                    <option>Anthropology</option>
                                    <option>Arabic Studies</option>
                                </select>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="input-box">
                                <input type="text" placeholder="First Name">
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="input-box">
                                <input type="text" placeholder="Last Name">
                            </div>
                        </div>
                        <div class="col-sm-12">
                            <div class="input-box">
                                <input type="text" placeholder="Email">
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="input-box">
                                <input type="text" placeholder="Phone Number">
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="input-box">
                                <input type="text" placeholder="ZIP/Postal Code">
                            </div>
                        </div>
                        <div class="col-sm-12">
                            <div class="submit-box">
                                <input type="submit" value="Request Information">
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <section class="safe-environment">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-12 col-md-4">
                            <div class="section-title2">
                                <h2>Providing safe and educational environment</h2>
                            </div>
                        </div>
                        <div class="col-md-4 col-sm-6">
                            <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since </p>
                            <p>type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic</p>
                        </div>
                        <div class="col-md-4 col-sm-6">
                            <p>type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into  </p>
                            <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's  </p>
                        </div>
                    </div>
                </div>
            </section>
            <section class="our-advantages">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-4">
                            <div class="advantages-box">
                                <div class="img"><img src="images/learn-icon.png" alt=""></div>
                                <h3>Learn at your own place</h3>
                                <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's stanypesetting, </p>
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="advantages-box">
                                <div class="img"><img src="images/save-timeIcon.png" alt=""></div>
                                <h3>Save time and money</h3>
                                <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy </p>
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="advantages-box">
                                <div class="img"><img src="images/online-learningIcon.png" alt=""></div>
                                <h3>100% Online learning</h3>
                                <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy </p>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <section class="our-studies">
                <div class="container">
                    <div class="section-title2">
                        <h2>Our Studies</h2>
                    </div>
                    <div class="row">
                        <div class="col-sm-6 col-md-4">
                            <div class="studies-box color1">
                                <div class="name"><a href="#">Bachelor in Architecture</a></div>
                                <p>It has survived not only five</p>
                            </div>
                        </div>
                        <div class="col-sm-6 col-md-4">
                            <div class="studies-box color2">
                                <div class="name"><a href="#">Bachelor in International Relations</a></div>
                                <p>Lorem Ipsum is simply dummy text</p>
                            </div>
                        </div>
                        <div class="col-sm-6 col-md-4">
                            <div class="studies-box color3">
                                <div class="name"><a href="#">Bachelor in Psychology</a></div>
                                <p>It has survived not only five</p>
                            </div>
                        </div>
                        <div class="col-sm-6 col-md-4">
                            <div class="studies-box color4">
                                <div class="name"><a href="#">Bachelor in Business Administration</a></div>
                                <p>Lorem Ipsum is simply dummy text</p>
                            </div>
                        </div>
                        <div class="col-sm-6 col-md-4">
                            <div class="studies-box color5">
                                <div class="name"><a href="#">Bachelor of Laws (LL.B.)</a></div>
                                <p>It has survived not only five</p>
                            </div>
                        </div>
                        <div class="col-sm-6 col-md-4">
                            <div class="studies-box color6">
                                <div class="name"><a href="#">Bachelor in Information Systems Management</a></div>
                                <p>Lorem Ipsum is simply dummy text</p>
                            </div>
                        </div>
                        <div class="col-sm-6 col-md-4">
                            <div class="studies-box color7">
                                <div class="name"><a href="#">Bachelor in Design</a></div>
                                <p>It has survived not only five</p>
                            </div>
                        </div>
                        <div class="col-sm-6 col-md-4">
                            <div class="studies-box color8">
                                <div class="name"><a href="#">Bachelor in Architecture</a></div>
                                <p>Lorem Ipsum is simply dummy text</p>
                            </div>
                        </div>
                        <div class="col-sm-6 col-md-4">
                            <div class="studies-box color9">
                                <div class="name"><a href="#">Bachelor in Politics, Law and Economics (PLE)</a></div>
                                <p>It has survived not only five</p>
                            </div>
                        </div>
                        <div class="col-sm-6 col-md-4">
                            <div class="studies-box color10">
                                <div class="name"><a href="#">Bachelor in Architecture</a></div>
                                <p>Lorem Ipsum is simply dummy text</p>
                            </div>
                        </div>
                        <div class="col-sm-6 col-md-4">
                            <div class="studies-box color11">
                                <div class="name"><a href="#">Bachelor in Architecture</a></div>
                                <p>It has survived not only five</p>
                            </div>
                        </div>
                        <div class="col-sm-6 col-md-4">
                            <div class="studies-box color12">
                                <div class="name"><a href="#">Dual Degree in Laws & International Relations</a></div>
                                <p>Lorem Ipsum is simply dummy text</p>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <section class="sign-upBox" style="background-image:url(images/parallax/sign-upBg.jpg);">
                <img src="images/parallax/sign-upBg.jpg" alt="">
                <div class="sign-upText">
                    <h3><span>Like what you’re learning</span>Get Started Today!</h3>
                    <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry lorem Ipsum has been the industry's standard dummy </p>
                    <div class="sign-btn">
                        <a href="#">Sign Up</a>
                    </div>
                </div>
            </section>
            <section class="news-section">
                <div class="container">
                    <div class="section-title2">
                        <h2>Latest News and Events </h2>
                    </div>
                    <div class="row">
                        <div class="col-md-6 col-sm-12">
                            <div class="news-box img" style="background-image:url(images/news/news-img1.jpg);">
                                <div class="category">News</div>
                                <div class="name"><a href="#">Post with Image Here</a></div>
                                <div class="date">24 Jan, 2017</div>
                                <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
                                <a href="#" class="read-more">Read More</a>
                            </div>
                        </div>
                        <div class="col-sm-6 col-md-3">
                            <div class="news-box">
                                <div class="category">Event</div>
                                <div class="name"><a href="#">Post with Image Here</a></div>
                                <div class="date">24 Jan, 2017</div>
                                <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
                                <a href="#" class="read-more">Read More</a>
                            </div>
                        </div>
                        <div class="col-sm-6 col-md-3">
                            <div class="news-box">
                                <div class="category">Event</div>
                                <div class="name"><a href="#">Post with Image Here</a></div>
                                <div class="date">24 Jan, 2017</div>
                                <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
                                <a href="#" class="read-more">Read More</a>
                            </div>
                        </div>
                        <div class="col-sm-6 col-md-3">
                            <div class="news-box">
                                <div class="category">Event</div>
                                <div class="name"><a href="#">Post with Image Here</a></div>
                                <div class="date">24 Jan, 2017</div>
                                <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
                                <a href="#" class="read-more">Read More</a>
                            </div>
                        </div>
                        <div class="col-sm-6 col-md-3">
                            <div class="news-box">
                                <div class="category">Event</div>
                                <div class="name"><a href="#">Post with Image Here</a></div>
                                <div class="date">24 Jan, 2017</div>
                                <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
                                <a href="#" class="read-more">Read More</a>
                            </div>
                        </div>
                        <div class="col-md-6 col-sm-12">
                            <div class="news-box img" style="background-image:url(images/news/news-img2.jpg);">
                                <div class="category">News</div>
                                <div class="name"><a href="#">Post with Image Here</a></div>
                                <div class="date">24 Jan, 2017</div>
                                <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
                                <a href="#" class="read-more">Read More</a>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <section class="student-reviews">
                <div class="container">
                    <div class="section-title2">
                        <h2>Our Student Say</h2>
                    </div>
                    <div class="reviews-slider">
                        <div class="item">
                            <div class="student-box">
                                <div class="img"><img src="images/user-img/student-img2.png" alt=""></div>
                                <p>"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. </p>
                                <div class="name">- Avishek S</div>
                            </div>
                        </div>
                        <div class="item">
                            <div class="student-box">
                                <div class="img"><img src="images/user-img/student-img3.png" alt=""></div>
                                <p>"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.  </p>
                                <div class="name">- John Doe</div>
                            </div>
                        </div>

                        <div class="item">
                            <div class="student-box">
                                <div class="img"><img src="images/user-img/student-img2.png" alt=""></div>
                                <p>"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. </p>
                                <div class="name">- Avishek S</div>
                            </div>
                        </div>
                        <div class="item">
                            <div class="student-box">
                                <div class="img"><img src="images/user-img/student-img3.png" alt=""></div>
                                <p>"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.  </p>
                                <div class="name">- John Doe</div>
                            </div>
                        </div>
                    </div>
                </div>
            </section> 
            <section class="newsletter-block" style="background-image:url(images/parallax/newsletter-bg.jpg);">
                <div class="container">
                    <label>SUBCRIBE WEEKLY NEWSLETTER</label>
                    <div class="input-box">
                        <input type="text" placeholder="Mobile Number for register">
                        <input type="submit" value="Submit">
                    </div>
                </div>
            </section>
            <footer id="footer" class="style2">
                <div class="footer-top">
                    <div class="container">
                        <div class="row">
                            <div class="col-sm-6 col-md-3">
                                <div class="footer-logo"><a href="#"><img src="images/logo3.png" alt=""></a></div>
                                <div class="footer-text">
                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut et lobortis diam vestibulum eget varius id, vulputate et mi. Nullam feugiat, diam quis interdum varius </p>
                                    <div class="read-more">
                                        <a href="#">Read More</a>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-6 col-md-3">
                                <h5>Popular Courses</h5>
                                <ul class="footer-link courses-list">
                                    <li><a href="#">Management</a></li>
                                    <li><a href="#">Banking</a></li>
                                    <li><a href="#">Government Recruitment</a></li>
                                </ul>
                            </div>
                            <div class="col-sm-6 col-md-3">
                                <h5>Quick Links</h5>
                                <ul class="footer-link">
                                    <li><a href="#">Summer Sessions</a></li>
                                    <li><a href="#">Professional Courses</a></li>
                                    <li><a href="#">Privacy Policy</a></li>
                                    <li><a href="#">Terms of Use</a></li>
                                </ul>
                            </div>
                            <div class="col-sm-6 col-md-3">
                                <h5>Contact Us</h5>
                                <div class="contact-view">
                                    <div class="contact-slide">
                                        <p><i class="fa fa-location-arrow"></i>76 Woodland Ave. Sherman Drive  <br>Fort Walton Beach,Harlingen</p>
                                    </div>
                                    <div class="contact-slide">
                                        <p><i class="fa fa-phone"></i>+299 97 39 82</p>
                                    </div>
                                    <div class="contact-slide">
                                        <p><i class="fa fa-fax"></i>(08) 8971 7450</p>
                                    </div>
                                    <div class="contact-slide">
                                        <p><i class="fa fa-envelope"></i><a href="mailTo:academy@info.com">academy@info.com</a></p>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="footer-bottom">
                    <div class="container">
                        <div class="row">
                            <div class="col-sm-8">
                                <div class="copy-right">
                                    <p>Copyright © <span class="year">2016</span> Academy All Rights Reserved</p>
                                </div>
                            </div>
                            <div class="col-sm-4">	
                                <div class="social-media">
                                    <ul>
                                        <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                                        <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                                        <li><a href="#"><i class="fa fa-skype"></i></a></li>
                                        <li><a href="#"><i class="fa fa-youtube"></i></a></li>
                                        <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </footer>
            <div class="top-arrow" id="goTop">
                <div class="arrow"><i class="fa fa-angle-up"></i></div>
            </div>
            <div class="search-blcok">
                <div class="close-icon">
                    <i class="fa fa-close"></i>
                </div>
                <div class="input-box">
                    <input type="text" placeholder="Enter Keyword">
                    <div class="note">Input your search keywords and press Enter.</div>
                </div>
            </div>
        </div>
        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->

        <script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.js"></script>
        <script type="text/javascript" src="js/owl.carousel.js"></script>
        <script type="text/javascript" src="js/jquery.form-validator.min.js"></script>
        <script type="text/javascript" src="js/jquery.selectbox-0.2.js"></script>
        <script type="text/javascript" src="js/placeholder.js"></script>
        <script type="text/javascript" src="js/coustem.js"></script>
    </body>
</html>
