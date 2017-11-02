<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Meta information -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <!-- Mobile Specific Metas -->

    <!-- Title -->
    <title>Academy</title>

    <!-- favicon icon -->
    <link rel="shortcut icon" href="images/Favicon.ico">

    <!-- CSS Stylesheet -->
    <link href="css/bootstrap.css" rel="stylesheet">
    <!-- bootstrap css -->
    <link href="css/owl.carousel.css" rel="stylesheet">
    <!-- carousel Slider -->
    <link href="css/font-awesome.css" rel="stylesheet">
    <!-- font awesome -->
    <link href="css/docs.css" rel="stylesheet">
    <!--  template structure css -->
    <link href="css/jquery.selectbox.css" rel="stylesheet"><!-- select box -->
    <link href="css/bootstrap.css" rel="stylesheet"><!-- bootstrap css -->
    <link href="css/owl.carousel.css" rel="stylesheet"><!-- carousel Slider -->
    <link href="css/font-awesome.css" rel="stylesheet"><!-- font awesome -->
    <link href="css/loader.css" rel="stylesheet"><!--  loader css -->
    <link href="css/jquery.selectbox.css" rel="stylesheet"><!-- select box -->
    <link href="css/docs.css" rel="stylesheet"><!--  template structure css -->

    <link href="https://fonts.googleapis.com/css?family=Arima+Madurai:100,200,300,400,500,700,800,900%7CPT+Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i"
        rel="stylesheet">
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->

</head>

<body>
    <div class="wapper">
        <jsp:include page="quicknav-2.jsp" flush="true"></jsp:include>
        </div>
        <header id="header">
            <div class="container">
                <nav id="nav-main">
                    <div class="navbar navbar-inverse">
                        <div class="navbar-header">
                            <a href="index.html" class="navbar-brand">
                                <img src="images/logo.png" alt="">
                            </a>
                            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>
                        </div>
                        <div class="cart-box">
                            <a href="cart.html">
                                <i class="fa fa-shopping-basket"></i>
                            </a>
                        </div>
                        <div class="navbar-collapse collapse">
                            <ul class="nav navbar-nav">
                                <li class="sub-menu">
                                    <a href="index.html">Home </a>
                                    <ul>
                                        <li>
                                            <a href="index.html">Home-1</a>
                                        </li>
                                        <li>
                                            <a href="index-2.html">Home-2</a>
                                        </li>
                                    </ul>
                                </li>
                                <li class="mega-menu sub-menu">
                                    <a href="courses-list.html">Courses</a>
                                    <div class="menu-view">
                                        <div class="row">
                                            <div class="col-sm-4">
                                                <div class="menu-title">Courses Page</div>
                                                <ul>
                                                    <li>
                                                        <a href="courses-gride.html">Courses Grid</a>
                                                    </li>
                                                    <li>
                                                        <a href="courses-gride-sideBar.html">Courses Grid SideBar</a>
                                                    </li>
                                                    <li>
                                                        <a href="courses-list.html">Courses List</a>
                                                    </li>
                                                    <li>
                                                        <a href="courses-list-sideBar.html">Courses List SideBar</a>
                                                    </li>
                                                    <li>
                                                        <a href="course-details.html">Course Details</a>
                                                    </li>
                                                </ul>
                                            </div>
                                            <div class="col-sm-4">
                                                <div class="menu-title">Quiz Page</div>
                                                <ul>
                                                    <li>
                                                        <a href="quiz-intro.html">Quiz Intro</a>
                                                    </li>
                                                    <li>
                                                        <a href="quiz.html">Quiz</a>
                                                    </li>
                                                    <li>
                                                        <a href="quiz-result.html">Quiz Result</a>
                                                    </li>
                                                </ul>
                                            </div>
                                            <div class="col-sm-4 menu-courses">
                                                <div class="menu-title">Popular Courses</div>
                                                <div class="courses-slide">
                                                    <div class="img">
                                                        <img src="images/blog/post-img1.jpg" alt="">
                                                    </div>
                                                    <div class="name">
                                                        <a href="courses-gride.html">Business Management</a>
                                                    </div>
                                                    <div class="price">$500</div>
                                                </div>
                                                <div class="courses-slide">
                                                    <div class="img">
                                                        <img src="images/blog/post-img2.jpg" alt="">
                                                    </div>
                                                    <div class="name">
                                                        <a href="courses-gride.html">Computing Science</a>
                                                    </div>
                                                    <div class="price">$255</div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                                <li class="sub-menu mega-menu">
                                    <a href="#">Pages </a>
                                    <div class="menu-view">
                                        <div class="row">
                                            <div class="col-sm-4">
                                                <div class="menu-title">Pages</div>
                                                <ul>
                                                    <li>
                                                        <a href="blog.html">Blog</a>
                                                    </li>
                                                    <li>
                                                        <a href="blog-details.html">Blog Details</a>
                                                    </li>
                                                    <li>
                                                        <a href="cart.html">Cart</a>
                                                    </li>
                                                    <li>
                                                        <a href="check-out.html">Check Out</a>
                                                    </li>
                                                    <li>
                                                        <a href="instructors.html">Instructors</a>
                                                    </li>
                                                    <li>
                                                        <a href="instructor-profile.html">Instructor Profile</a>
                                                    </li>
                                                    <li>
                                                        <a href="faq.html">Faq</a>
                                                    </li>
                                                </ul>
                                            </div>
                                            <div class="col-sm-4">
                                                <div class="menu-title"></div>
                                                <ul>
                                                    <li>
                                                        <a href="course-details-free.html">Course Details Free</a>
                                                    </li>
                                                    <li>
                                                        <a href="course-lessons.html">Course Lessons</a>
                                                    </li>
                                                    <li>
                                                        <a href="gallery.html">Gallery</a>
                                                    </li>
                                                    <li>
                                                        <a href="thank-you.html">Thank You</a>
                                                    </li>
                                                    <li>
                                                        <a href="coming-soon.html">Comming Soon</a>
                                                        <li>
                                                            <a href="page-404.html">404 Page</a>
                                                        </li>
                                                        <li>
                                                            <a href="certificate.html">Certificate</a>
                                                        </li>
                                                </ul>
                                            </div>
                                            <div class="col-sm-4">
                                                <div class="menu-title">After Login</div>
                                                <ul>

                                                    <li>
                                                        <a href="login-register.html">Login Register</a>
                                                    </li>
                                                    <li>
                                                        <a href="account-settings.html">Account Settings</a>
                                                    </li>
                                                    <li>
                                                        <a href="my-courses.html">My Courses</a>
                                                    </li>
                                                    <li>
                                                        <a href="course-progress.html">Course Progress</a>
                                                    </li>
                                                    <li>
                                                        <a href="course-home.html">Course Home</a>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                    </li>
                                    <li class="sub-menu">
                                        <a href="#">Features</a>
                                        <ul>
                                            <li>
                                                <a href="typography.html">Typography</a>
                                            </li>
                                            <li>
                                                <a href="price-plan.html">Price Plan</a>
                                            </li>
                                            <li>
                                                <a href="testimonial.html">Testimonial</a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li>
                                        <a href="about-us.html">About Us</a>
                                    </li>
                                    <li class="sub-menu">
                                        <a href="event.html">Event</a>
                                        <ul>
                                            <li>
                                                <a href="event.html">Event</a>
                                            </li>
                                            <li>
                                                <a href="event-details.html">Event Details</a>
                                            </li>
                                            <li>
                                                <a href="event-details2.html">Event Details2</a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li class="sub-menu mega-menu">
                                        <a href="forums.html">Forums</a>
                                        <div class="menu-view">
                                            <div class="row">
                                                <div class="col-sm-4">
                                                    <div class="menu-title">Forums</div>
                                                    <ul>
                                                        <li>
                                                            <a href="forums-detail.html">Forums Detail</a>
                                                        </li>
                                                        <li>
                                                            <a href="forums-group.html">Forums Group</a>
                                                        </li>
                                                        <li>
                                                            <a href="forums-group-details.html">Forums Group Details</a>
                                                        </li>
                                                        <li>
                                                            <a href="forums-group-member.html">Forums Group Member</a>
                                                        </li>
                                                    </ul>
                                                </div>
                                                <div class="col-sm-4">
                                                    <div class="menu-title"></div>
                                                    <ul>
                                                        <li>
                                                            <a href="forum-single-topic.html">Forum Single Topic</a>
                                                        </li>
                                                        <li>
                                                            <a href="forums-members.html">Forums Members</a>
                                                        </li>
                                                        <li>
                                                            <a href="forums-profile.html">Forums Profile</a>
                                                        </li>
                                                        <li>
                                                            <a href="forums-profile-activity.html">Forums Profile Activity</a>
                                                        </li>
                                                    </ul>
                                                </div>
                                                <div class="col-sm-4">
                                                    <div class="menu-title"></div>
                                                    <ul>
                                                        <li>
                                                            <a href="forums-profile-forums.html">Forums Profile Forums</a>
                                                        </li>
                                                        <li>
                                                            <a href="forums-profile-friends.html">Forums Profile Friends</a>
                                                        </li>
                                                        <li>
                                                            <a href="forums-profile-groups.html">Forums Profile Groups</a>
                                                        </li>
                                                        <li>
                                                            <a href="forums-single-profile.html">Forums Single Profile</a>
                                                        </li>
                                                    </ul>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                    <li>
                                        <a href="contact-us.html">Contact Us </a>
                                    </li>
                            </ul>
                        </div>
                    </div>
                </nav>
            </div>
        </header>
        <section class="banner inner-page">
            <div class="banner-img">
                <img src="images/banner/register-bannerImg.jpg" alt="">
            </div>
            <div class="page-title">
                <div class="container">
                    <h1>Login</h1>
                </div>
            </div>
        </section>
        <section class="breadcrumb">
            <div class="container">
                <ul>
                    <li>
                        <a href="#">Home</a>
                    </li>
                    <li>
                        <a href="#">Login & Register</a>
                    </li>
                </ul>
            </div>
        </section>
        <section class="login-view">
            <div class="container">
                <div class="row">
                    <div class="col-sm-6">
                        <div class="section-title">
                            <h2>Login</h2>
                            <p>Login to your account below</p>
                        </div>
                        <div class="input-box">
                            <input type="text" placeholder="User Name">
                        </div>
                        <div class="input-box">
                            <input type="text" placeholder="Password">
                        </div>
                        <div class="check-slide">
                            <label class="label_check" for="checkbox-01">
                                <input id="checkbox-01" type="checkbox"> Remember Me</label>
                            <div class="right-link">
                                <a href="#">Lost Password? </a>
                            </div>
                        </div>
                        <div class="submit-slide">
                            <input type="submit" value="Login" class="btn">

                        </div>
                    </div>
                    <div class="col-sm-6">
                        <form action="register" method="post">
                            <div class="section-title">
                                <h2>REGISTER</h2>
                                <p>Register now - Completely free</p>
                            </div>
                            <div class="input-box">
                                <input type="text" name="id" required placeholder="Matricula AXXXXXXX">
                            </div>
                            <div class="input-box">
                                <input type="text" name="firstName" required placeholder="Nombre(s)">
                            </div>
                            <div class="input-box">
                                <input type="text" name="lastName1" required placeholder="Apellido Paterno">
                            </div>
                            <div class="input-box">
                                <input type="text" name="lastName2" placeholder="Apellido Materno">
                            </div>
                            <div class="input-box">
                                <input type="text" name="email" required placeholder="Email">
                            </div>
                            <div class="input-box">
                                <input type="password" name="password" required placeholder="Password">
                            </div>
                            <div class="input-box">
                                <input type="password" name="confirm-password" required placeholder="Re-Password">
                            </div>
                            <div class="select-box">
                                    <select class="degree-select">
                                        <option>ITIC</option>
                                        <option>IIS</option>
                                        <option>IBN</option>
                                        <option>IMT</option>
                                    </select>
                                </div>
                            <div class="submit-slide">
                                <input type="submit" value="SIGN UP" class="btn">
                            </div>
                        </form>
                    </div>
                </div>
                <div class="sosiyal-login">
                    <div class="row">
                        <div class="col-sm-3 col-md-3">
                            <a href="#" class="facebook">
                                <i class="fa fa-facebook"></i>Facebook</a>
                        </div>
                        <div class="col-sm-3 col-md-3">
                            <a href="#" class="google-pluse">
                                <i class="fa fa-google-plus"></i>Google</a>
                        </div>
                        <div class="col-sm-3 col-md-3">
                            <a href="#" class="twitter">
                                <i class="fa fa-twitter"></i>Twitter</a>
                        </div>
                        <div class="col-sm-3 col-md-3">
                            <a href="#" class="linkedin">
                                <i class="fa fa-linkedin"></i>Linkedin</a>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <footer id="footer">
            <div class="footer-top">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-6 col-md-3">
                            <h5>Popular Courses</h5>
                            <div class="course-slide">
                                <div class="img">
                                    <img src="images/blog/post-img1.jpg" alt="">
                                </div>
                                <p>
                                    <a href="courses-list.html">when an unknown printer took </a>
                                </p>
                                <div class="price">$55</div>
                            </div>
                            <div class="course-slide">
                                <div class="img">
                                    <img src="images/blog/post-img2.jpg" alt="">
                                </div>
                                <p>
                                    <a href="courses-list-sideBar.html">when an unknown printer took </a>
                                </p>
                                <div class="price">$505</div>
                            </div>
                            <div class="course-slide">
                                <div class="img">
                                    <img src="images/blog/post-img3.jpg" alt="">
                                </div>
                                <p>
                                    <a href="courses-list.html">when an unknown printer took </a>
                                </p>
                                <div class="price">$178</div>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="row">
                                <div class="col-md-offset-1 col-sm-6 col-md-5 col-xs-6">
                                    <h5>Company</h5>
                                    <ul class="footer-link">
                                        <li>
                                            <a href="about-us.html">About Us</a>
                                        </li>
                                        <li>
                                            <a href="contact-us.html">Contact</a>
                                        </li>
                                        <li>
                                            <a href="blog.html">Blog</a>
                                        </li>
                                        <li>
                                            <a href="event.html">Event</a>
                                        </li>
                                        <li>
                                            <a href="gallery.html">Gallery</a>
                                        </li>
                                        <li>
                                            <a href="instructor-profile.html">Instructor Profile</a>
                                        </li>
                                    </ul>
                                </div>
                                <div class="col-md-offset-1 col-sm-6 col-md-5 col-xs-6">
                                    <h5>Links</h5>
                                    <ul class="footer-link">
                                        <li>
                                            <a href="courses-list.html">Courses List</a>
                                        </li>
                                        <li>
                                            <a href="price-plan.html">Pricing Table</a>
                                        </li>
                                        <li>
                                            <a href="instructors.html">Instructors</a>
                                        </li>
                                        <li>
                                            <a href="forums.html">Forums</a>
                                        </li>
                                        <li>
                                            <a href="faq.html">Faq</a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6 col-md-3">
                            <h5>Contact Us</h5>
                            <div class="contact-view">
                                <div class="contact-slide">
                                    <p>
                                        <i class="fa fa-location-arrow"></i>76 Woodland Ave. Sherman Drive
                                        <br>Fort Walton Beach,Harlingen</p>
                                </div>
                                <div class="contact-slide">
                                    <p>
                                        <i class="fa fa-phone"></i>+299 97 39 82</p>
                                </div>
                                <div class="contact-slide">
                                    <p>
                                        <i class="fa fa-fax"></i>(08) 8971 7450</p>
                                </div>
                                <div class="contact-slide">
                                    <p>
                                        <i class="fa fa-envelope"></i>
                                        <a href="mailTo:academy@info.com">academy@info.com</a>
                                    </p>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-sm-8">
                        <div class="copy-right">
                            <p>Copyright ©
                                <span class="year">2016</span> Academy.</p>
                            <ul class="footer-link">
                                <li>
                                    <a href="#">Terms and Conditions</a>
                                </li>
                                <li>
                                    <a href="#">Privacy</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-sm-4 ">
                        <div class="social-media">
                            <ul>
                                <li>
                                    <a href="#">
                                        <i class="fa fa-facebook"></i>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <i class="fa fa-twitter"></i>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <i class="fa fa-skype"></i>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <i class="fa fa-youtube"></i>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <i class="fa fa-linkedin"></i>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </footer>
    </div>
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->

    <script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
    <script type="text/javascript" src="js/owl.carousel.js"></script>
    <script type="text/javascript" src="js/jquery.form-validator.min.js"></script>
    <script type="text/javascript" src="js/placeholder.js"></script>
    <script type="text/javascript" src="js/coustem.js"></script>
</body>

</html>