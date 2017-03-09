<%@page import="com.javawebtutor.service.StoreService"%>
<%@page import="java.util.List"%>
<%@page import="com.javawebtutor.service.LoginService"%>
<%@page import="java.util.Date"%>
<%@page import="com.javawebtutor.model.User"%>
<%@page import="com.javawebtutor.model.Store"%>
<%@page import="org.hibernate.Query"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.Transaction"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>Smart Shopper | Dashboard</title>

		<meta name="description" content="overview &amp; stats" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

		<!-- bootstrap & fontawesome -->
		<link rel="stylesheet" href="assets/css/bootstrap.min.css" />
		<link rel="stylesheet" href="assets/font-awesome/4.5.0/css/font-awesome.min.css" />

		<!-- page specific plugin styles -->

		<!-- text fonts -->
		<link rel="stylesheet" href="assets/css/fonts.googleapis.com.css" />

		<!-- ace styles -->
		<link rel="stylesheet" href="assets/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />

		<!--[if lte IE 9]>
			<link rel="stylesheet" href="assets/css/ace-part2.min.css" class="ace-main-stylesheet" />
		<![endif]-->
		<link rel="stylesheet" href="assets/css/ace-skins.min.css" />
		<link rel="stylesheet" href="assets/css/ace-rtl.min.css" />

		<!--[if lte IE 9]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->

		<!-- inline styles related to this page -->

		<!-- ace settings handler -->
		<script src="assets/js/ace-extra.min.js"></script>

		<!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

		<!--[if lte IE 8]>
		<script src="assets/js/html5shiv.min.js"></script>
		<script src="assets/js/respond.min.js"></script>
		<![endif]-->
	</head>

	<body class="no-skin">
		<div id="navbar" class="navbar navbar-default          ace-save-state">
			<div class="navbar-container ace-save-state" id="navbar-container">
				<button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler" data-target="#sidebar">
					<span class="sr-only">Toggle sidebar</span>

					<span class="icon-bar"></span>

					<span class="icon-bar"></span>

					<span class="icon-bar"></span>
				</button>

				<div class="navbar-header pull-left">
					<a href="index.html" class="navbar-brand">
						<small>
							<!--<i class="fa fa-leaf"></i>  -->
							Smart Shopper
						</small>
					</a>
				</div>

				<div class="navbar-buttons navbar-header pull-right" role="navigation">
					<ul class="nav ace-nav">
						
						<li class="light-blue dropdown-modal">
							<a data-toggle="dropdown" href="#" class="dropdown-toggle">
								<img class="nav-user-photo" src="assets/images/avatars/user.jpg" alt="Jason's Photo" />
								<span class="user-info">
									<small>Welcome,</small>
									 <%
				 User user = (User) session.getAttribute("user");
			 %>		
			 
			 
			 <b><%= user.getName() %></b>
								</span>

								<i class="ace-icon fa fa-caret-down"></i>
							</a>

							<ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
								<li>
									<a href="settings.jsp">
										<i class="ace-icon fa fa-cog"></i>
										Settings
									</a>
								</li>

								<li>
									<a href="profile.jsp">
										<i class="ace-icon fa fa-user"></i>
										Profile
									</a>
								</li>
								
								<li>
									<a href="logout.jsp">
										<i class="ace-icon fa fa-power-off"></i>
										Logout
									</a>
								</li>

								<li class="divider"></li>
								
							</ul>
						</li>
					</ul>
				</div>
			</div><!-- /.navbar-container -->
		</div>

		<div class="main-container ace-save-state" id="main-container">
			<script type="text/javascript">
				try{ace.settings.loadState('main-container')}catch(e){}
			</script>

			<div id="sidebar" class="sidebar                  responsive                    ace-save-state">
				<script type="text/javascript">
					try{ace.settings.loadState('sidebar')}catch(e){}
				</script>

				<div class="sidebar-shortcuts" id="sidebar-shortcuts">
					<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
						<button class="btn btn-success">
							<i class="ace-icon fa fa-signal"></i>
						</button>

						<button class="btn btn-info">
							<i class="ace-icon fa fa-pencil"></i>
						</button>

						<button class="btn btn-warning">
							<i class="ace-icon fa fa-users"></i>
						</button>

						<button class="btn btn-danger">
							<i class="ace-icon fa fa-cogs"></i>
						</button>
					</div>

					<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
						<span class="btn btn-success"></span>

						<span class="btn btn-info"></span>

						<span class="btn btn-warning"></span>

						<span class="btn btn-danger"></span>
					</div>
				</div><!-- /.sidebar-shortcuts -->

				<ul class="nav nav-list">
					<li class="active">
						<a href="home.jsp">
							<i class="menu-icon fa fa-tachometer"></i>
							<span class="menu-text"> Dashboard </span>
						</a>

						<b class="arrow"></b>
					</li>					

					<li class="">
						<a href="search.jsp">
							<i class="menu-icon fa fa-print orange"></i>
							<span class="menu-text"> Print Receipt </span>
						</a>

						<b class="arrow"></b>
					</li>
					
					<li class="">
						<a href="users.jsp">
							<i class="menu-icon fa fa-users green"></i>
							<span class="menu-text"> Users </span>
						</a>

						<b class="arrow"></b>
					</li>
					
					<li class="">
						<a href="groups.jsp">
							<i class="menu-icon fa fa-database black"></i>
							<span class="menu-text"> Groups </span>
						</a>

						<b class="arrow"></b>
					</li>
					
					<li class="">
						<a href="products.jsp">
							<i class="menu-icon fa fa-list blue"></i>
							<span class="menu-text"> Products </span>
						</a>

						<b class="arrow"></b>
					</li>
					
					<li class="">
						<a href="stores.jsp">
							<i class="menu-icon fa fa-picture-o indigo"></i>
							<span class="menu-text"> Stores </span>
						</a>

						<b class="arrow"></b>
					</li>
					
					<li class="">
						<a href="profile.jsp">
							<i class="menu-icon fa fa-eye pink"></i>
							<span class="menu-text"> Profile </span>
						</a>

						<b class="arrow"></b>
					</li>
					
					<li class="">
						<a href="reports.jsp">
							<i class="menu-icon fa fa-tasks red"></i>
							<span class="menu-text"> Reports </span>
						</a>

						<b class="arrow"></b>
					</li>			
					
					<li class="">
						<a href="contact.jsp">
							<i class="menu-icon fa fa-pencil-square-o purple"></i>
							<span class="menu-text"> Contact </span>
						</a>

						<b class="arrow"></b>
					</li>	
					

					
				</ul><!-- /.nav-list -->

				<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
					<i id="sidebar-toggle-icon" class="ace-icon fa fa-angle-double-left ace-save-state" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
				</div>
			</div>

			<div class="main-content">
				<div class="main-content-inner">
					<div class="breadcrumbs ace-save-state" id="breadcrumbs">
						<ul class="breadcrumb">
							<li>
								<i class="ace-icon fa fa-home home-icon"></i>
								<a href="#">Home</a>
							</li>
							<li class="active">Dashboard</li>
						</ul><!-- /.breadcrumb -->

						
					</div>

					<div class="page-content">
						

						<div class="page-header">
							<h1>
								Dashboard
								<small>
									<i class="ace-icon fa fa-angle-double-right"></i>
									overview &amp; stats
								</small>
							</h1>
						</div><!-- /.page-header -->

						<div class="row">
							<div class="col-bg-12">
								<!-- PAGE CONTENT BEGINS -->
								
								<div class="clearfix">
									

									<!--<div class="pull-right">
										<span class="green middle bolder">Choose profile: &nbsp;</span>

										<div class="btn-toolbar inline middle no-margin">
											<div data-toggle="buttons" class="btn-group no-margin">
												<label class="btn btn-sm btn-yellow active">
													<span class="bigger-110">1</span>

													<input type="radio" value="1" />
												</label>

												
											</div>
										</div>
									</div>  -->
								</div>

								<div class="hr dotted"></div>

								<div>
									<div id="user-profile-1" class="user-profile row">
										<div class="col-xs-12 col-sm-3 center">
											<div>
												<span class="profile-picture">
													<img id="avatar" class="editable img-responsive" alt="Alex's Avatar" src="assets/images/avatars/profile-pic.jpg" />
												</span>

												<div class="space-4"></div>

												
											</div>

																							
											</div>

											<div class="hr hr12 dotted"></div>											

											<div class="hr hr16 dotted"></div>
										</div>

										<div class="col-xs-12 col-sm-9">
											

											<div class="space-12"></div>

											<div class="profile-user-info profile-user-info-striped">
												<div class="profile-info-row">
													<div class="profile-info-name"> Username </div>

													<div class="profile-info-value">
														<span class="editable" id="username"><%= user.getName() %></span>
													</div>
												</div>

												<div class="profile-info-row">
													<div class="profile-info-name"> Email </div>

													<div class="profile-info-value">														
														<span class="editable" id="city"><%= user.getEmail() %></span>
													</div>
												</div>

												<div class="profile-info-row">
													<div class="profile-info-name"> ID / Passport </div>

													<div class="profile-info-value">
														<span class="editable" id="age"><%= user.getIdpass() %></span>
													</div>
												</div>
												
												<div class="profile-info-row">
													<div class="profile-info-name"> Phone Number </div>

													<div class="profile-info-value">
														<span class="editable" id="age"><%= user.getPhoneno() %></span>
													</div>
												</div>
												
												<div class="profile-info-row">
													<div class="profile-info-name"> Status </div>

													<div class="profile-info-value">
														<span class="editable" id="age"><%= user.getStatus() %></span>
													</div>
												</div>

												<div class="profile-info-row">
													<div class="profile-info-name"> Joined </div>

													<div class="profile-info-value">
														<span class="editable" id="signup"><%= user.getCreated_at() %></span>
													</div>
												</div>
												
											</div>

											<div class="space-20"></div>

											

											<div class="hr hr2 hr-double"></div>

											<div class="space-6"></div>

											
										</div>
									</div>
								</div>

								<div class="hide">
									<div id="user-profile-2" class="user-profile">
										<div class="tabbable">
											<ul class="nav nav-tabs padding-18">
												<li class="active">
													<a data-toggle="tab" href="#home">
														<i class="green ace-icon fa fa-user bigger-120"></i>
														Profile
													</a>
												</li>

												<li>
													<a data-toggle="tab" href="#feed">
														<i class="orange ace-icon fa fa-rss bigger-120"></i>
														Activity Feed
													</a>
												</li>

												<li>
													<a data-toggle="tab" href="#friends">
														<i class="blue ace-icon fa fa-users bigger-120"></i>
														Friends
													</a>
												</li>

												<li>
													<a data-toggle="tab" href="#pictures">
														<i class="pink ace-icon fa fa-picture-o bigger-120"></i>
														Pictures
													</a>
												</li>
											</ul>

											<div class="tab-content no-border padding-24">
												<div id="home" class="tab-pane in active">
													<div class="row">
														<div class="col-xs-12 col-sm-3 center">
															<span class="profile-picture">
																<img class="editable img-responsive" alt="Alex's Avatar" id="avatar2" src="assets/images/avatars/profile-pic.jpg" />
															</span>

															<div class="space space-4"></div>

															<a href="#" class="btn btn-sm btn-block btn-success">
																<i class="ace-icon fa fa-plus-circle bigger-120"></i>
																<span class="bigger-110">Add as a friend</span>
															</a>

															<a href="#" class="btn btn-sm btn-block btn-primary">
																<i class="ace-icon fa fa-envelope-o bigger-110"></i>
																<span class="bigger-110">Send a message</span>
															</a>
														</div><!-- /.col -->

														<div class="col-xs-12 col-sm-9">
															<h4 class="blue">
																<span class="middle">Alex M. Doe</span>

																<span class="label label-purple arrowed-in-right">
																	<i class="ace-icon fa fa-circle smaller-80 align-middle"></i>
																	online
																</span>
															</h4>

															<div class="profile-user-info">
																<div class="profile-info-row">
																	<div class="profile-info-name"> Username </div>

																	<div class="profile-info-value">
																		<span>alexdoe</span>
																	</div>
																</div>

																<div class="profile-info-row">
																	<div class="profile-info-name"> Location </div>

																	<div class="profile-info-value">
																		<i class="fa fa-map-marker light-orange bigger-110"></i>
																		<span>Netherlands</span>
																		<span>Amsterdam</span>
																	</div>
																</div>

																<div class="profile-info-row">
																	<div class="profile-info-name"> Age </div>

																	<div class="profile-info-value">
																		<span>38</span>
																	</div>
																</div>

																<div class="profile-info-row">
																	<div class="profile-info-name"> Joined </div>

																	<div class="profile-info-value">
																		<span>2010/06/20</span>
																	</div>
																</div>

																<div class="profile-info-row">
																	<div class="profile-info-name"> Last Online </div>

																	<div class="profile-info-value">
																		<span>3 hours ago</span>
																	</div>
																</div>
															</div>

															<div class="hr hr-8 dotted"></div>

															<div class="profile-user-info">
																<div class="profile-info-row">
																	<div class="profile-info-name"> Website </div>

																	<div class="profile-info-value">
																		<a href="#" target="_blank">www.alexdoe.com</a>
																	</div>
																</div>

																<div class="profile-info-row">
																	<div class="profile-info-name">
																		<i class="middle ace-icon fa fa-facebook-square bigger-150 blue"></i>
																	</div>

																	<div class="profile-info-value">
																		<a href="#">Find me on Facebook</a>
																	</div>
																</div>

																<div class="profile-info-row">
																	<div class="profile-info-name">
																		<i class="middle ace-icon fa fa-twitter-square bigger-150 light-blue"></i>
																	</div>

																	<div class="profile-info-value">
																		<a href="#">Follow me on Twitter</a>
																	</div>
																</div>
															</div>
														</div><!-- /.col -->
													</div><!-- /.row -->

													<div class="space-20"></div>

													<div class="row">
														<div class="col-xs-12 col-sm-6">
															<div class="widget-box transparent">
																<div class="widget-header widget-header-small">
																	<h4 class="widget-title smaller">
																		<i class="ace-icon fa fa-check-square-o bigger-110"></i>
																		Little About Me
																	</h4>
																</div>

																<div class="widget-body">
																	<div class="widget-main">
																		<p>
																			My job is mostly lorem ipsuming and dolor sit ameting as long as consectetur adipiscing elit.
																		</p>
																		<p>
																			Sometimes quisque commodo massa gets in the way and sed ipsum porttitor facilisis.
																		</p>
																		<p>
																			The best thing about my job is that vestibulum id ligula porta felis euismod and nullam quis risus eget urna mollis ornare.
																		</p>
																		<p>
																			Thanks for visiting my profile.
																		</p>
																	</div>
																</div>
															</div>
														</div>

														<div class="col-xs-12 col-sm-6">
															<div class="widget-box transparent">
																<div class="widget-header widget-header-small header-color-blue2">
																	<h4 class="widget-title smaller">
																		<i class="ace-icon fa fa-lightbulb-o bigger-120"></i>
																		My Skills
																	</h4>
																</div>

																<div class="widget-body">
																	<div class="widget-main padding-16">
																		<div class="clearfix">
																			<div class="grid3 center">
																				<div class="easy-pie-chart percentage" data-percent="45" data-color="#CA5952">
																					<span class="percent">45</span>%
																				</div>

																				<div class="space-2"></div>
																				Graphic Design
																			</div>

																			<div class="grid3 center">
																				<div class="center easy-pie-chart percentage" data-percent="90" data-color="#59A84B">
																					<span class="percent">90</span>%
																				</div>

																				<div class="space-2"></div>
																				HTML5 & CSS3
																			</div>

																			<div class="grid3 center">
																				<div class="center easy-pie-chart percentage" data-percent="80" data-color="#9585BF">
																					<span class="percent">80</span>%
																				</div>

																				<div class="space-2"></div>
																				Javascript/jQuery
																			</div>
																		</div>

																		<div class="hr hr-16"></div>

																		<div class="profile-skills">
																			<div class="progress">
																				<div class="progress-bar" style="width:80%">
																					<span class="pull-left">HTML5 & CSS3</span>
																					<span class="pull-right">80%</span>
																				</div>
																			</div>

																			<div class="progress">
																				<div class="progress-bar progress-bar-success" style="width:72%">
																					<span class="pull-left">Javascript & jQuery</span>

																					<span class="pull-right">72%</span>
																				</div>
																			</div>

																			<div class="progress">
																				<div class="progress-bar progress-bar-purple" style="width:70%">
																					<span class="pull-left">PHP & MySQL</span>

																					<span class="pull-right">70%</span>
																				</div>
																			</div>

																			<div class="progress">
																				<div class="progress-bar progress-bar-warning" style="width:50%">
																					<span class="pull-left">Wordpress</span>

																					<span class="pull-right">50%</span>
																				</div>
																			</div>

																			<div class="progress">
																				<div class="progress-bar progress-bar-danger" style="width:38%">
																					<span class="pull-left">Photoshop</span>

																					<span class="pull-right">38%</span>
																				</div>
																			</div>
																		</div>
																	</div>
																</div>
															</div>
														</div>
													</div>
												</div><!-- /#home -->

												<div id="feed" class="tab-pane">
													<div class="profile-feed row">
														<div class="col-sm-6">
															<div class="profile-activity clearfix">
																<div>
																	<img class="pull-left" alt="Alex Doe's avatar" src="assets/images/avatars/avatar5.png" />
																	<a class="user" href="#"> Alex Doe </a>
																	changed his profile photo.
																	<a href="#">Take a look</a>

																	<div class="time">
																		<i class="ace-icon fa fa-clock-o bigger-110"></i>
																		an hour ago
																	</div>
																</div>

																<div class="tools action-buttons">
																	<a href="#" class="blue">
																		<i class="ace-icon fa fa-pencil bigger-125"></i>
																	</a>

																	<a href="#" class="red">
																		<i class="ace-icon fa fa-times bigger-125"></i>
																	</a>
																</div>
															</div>

															<div class="profile-activity clearfix">
																<div>
																	<img class="pull-left" alt="Susan Smith's avatar" src="assets/images/avatars/avatar1.png" />
																	<a class="user" href="#"> Susan Smith </a>

																	is now friends with Alex Doe.
																	<div class="time">
																		<i class="ace-icon fa fa-clock-o bigger-110"></i>
																		2 hours ago
																	</div>
																</div>

																<div class="tools action-buttons">
																	<a href="#" class="blue">
																		<i class="ace-icon fa fa-pencil bigger-125"></i>
																	</a>

																	<a href="#" class="red">
																		<i class="ace-icon fa fa-times bigger-125"></i>
																	</a>
																</div>
															</div>

															<div class="profile-activity clearfix">
																<div>
																	<i class="pull-left thumbicon fa fa-check btn-success no-hover"></i>
																	<a class="user" href="#"> Alex Doe </a>
																	joined
																	<a href="#">Country Music</a>

																	group.
																	<div class="time">
																		<i class="ace-icon fa fa-clock-o bigger-110"></i>
																		5 hours ago
																	</div>
																</div>

																<div class="tools action-buttons">
																	<a href="#" class="blue">
																		<i class="ace-icon fa fa-pencil bigger-125"></i>
																	</a>

																	<a href="#" class="red">
																		<i class="ace-icon fa fa-times bigger-125"></i>
																	</a>
																</div>
															</div>

															<div class="profile-activity clearfix">
																<div>
																	<i class="pull-left thumbicon fa fa-picture-o btn-info no-hover"></i>
																	<a class="user" href="#"> Alex Doe </a>
																	uploaded a new photo.
																	<a href="#">Take a look</a>

																	<div class="time">
																		<i class="ace-icon fa fa-clock-o bigger-110"></i>
																		5 hours ago
																	</div>
																</div>

																<div class="tools action-buttons">
																	<a href="#" class="blue">
																		<i class="ace-icon fa fa-pencil bigger-125"></i>
																	</a>

																	<a href="#" class="red">
																		<i class="ace-icon fa fa-times bigger-125"></i>
																	</a>
																</div>
															</div>

															<div class="profile-activity clearfix">
																<div>
																	<img class="pull-left" alt="David Palms's avatar" src="assets/images/avatars/avatar4.png" />
																	<a class="user" href="#"> David Palms </a>

																	left a comment on Alex's wall.
																	<div class="time">
																		<i class="ace-icon fa fa-clock-o bigger-110"></i>
																		8 hours ago
																	</div>
																</div>

																<div class="tools action-buttons">
																	<a href="#" class="blue">
																		<i class="ace-icon fa fa-pencil bigger-125"></i>
																	</a>

																	<a href="#" class="red">
																		<i class="ace-icon fa fa-times bigger-125"></i>
																	</a>
																</div>
															</div>
														</div><!-- /.col -->

														<div class="col-sm-6">
															<div class="profile-activity clearfix">
																<div>
																	<i class="pull-left thumbicon fa fa-pencil-square-o btn-pink no-hover"></i>
																	<a class="user" href="#"> Alex Doe </a>
																	published a new blog post.
																	<a href="#">Read now</a>

																	<div class="time">
																		<i class="ace-icon fa fa-clock-o bigger-110"></i>
																		11 hours ago
																	</div>
																</div>

																<div class="tools action-buttons">
																	<a href="#" class="blue">
																		<i class="ace-icon fa fa-pencil bigger-125"></i>
																	</a>

																	<a href="#" class="red">
																		<i class="ace-icon fa fa-times bigger-125"></i>
																	</a>
																</div>
															</div>

															<div class="profile-activity clearfix">
																<div>
																	<img class="pull-left" alt="Alex Doe's avatar" src="assets/images/avatars/avatar5.png" />
																	<a class="user" href="#"> Alex Doe </a>

																	upgraded his skills.
																	<div class="time">
																		<i class="ace-icon fa fa-clock-o bigger-110"></i>
																		12 hours ago
																	</div>
																</div>

																<div class="tools action-buttons">
																	<a href="#" class="blue">
																		<i class="ace-icon fa fa-pencil bigger-125"></i>
																	</a>

																	<a href="#" class="red">
																		<i class="ace-icon fa fa-times bigger-125"></i>
																	</a>
																</div>
															</div>

															<div class="profile-activity clearfix">
																<div>
																	<i class="pull-left thumbicon fa fa-key btn-info no-hover"></i>
																	<a class="user" href="#"> Alex Doe </a>

																	logged in.
																	<div class="time">
																		<i class="ace-icon fa fa-clock-o bigger-110"></i>
																		12 hours ago
																	</div>
																</div>

																<div class="tools action-buttons">
																	<a href="#" class="blue">
																		<i class="ace-icon fa fa-pencil bigger-125"></i>
																	</a>

																	<a href="#" class="red">
																		<i class="ace-icon fa fa-times bigger-125"></i>
																	</a>
																</div>
															</div>

															<div class="profile-activity clearfix">
																<div>
																	<i class="pull-left thumbicon fa fa-power-off btn-inverse no-hover"></i>
																	<a class="user" href="#"> Alex Doe </a>

																	logged out.
																	<div class="time">
																		<i class="ace-icon fa fa-clock-o bigger-110"></i>
																		16 hours ago
																	</div>
																</div>

																<div class="tools action-buttons">
																	<a href="#" class="blue">
																		<i class="ace-icon fa fa-pencil bigger-125"></i>
																	</a>

																	<a href="#" class="red">
																		<i class="ace-icon fa fa-times bigger-125"></i>
																	</a>
																</div>
															</div>

															<div class="profile-activity clearfix">
																<div>
																	<i class="pull-left thumbicon fa fa-key btn-info no-hover"></i>
																	<a class="user" href="#"> Alex Doe </a>

																	logged in.
																	<div class="time">
																		<i class="ace-icon fa fa-clock-o bigger-110"></i>
																		16 hours ago
																	</div>
																</div>

																<div class="tools action-buttons">
																	<a href="#" class="blue">
																		<i class="ace-icon fa fa-pencil bigger-125"></i>
																	</a>

																	<a href="#" class="red">
																		<i class="ace-icon fa fa-times bigger-125"></i>
																	</a>
																</div>
															</div>
														</div><!-- /.col -->
													</div><!-- /.row -->

													<div class="space-12"></div>

													<div class="center">
														<button type="button" class="btn btn-sm btn-primary btn-white btn-round">
															<i class="ace-icon fa fa-rss bigger-150 middle orange2"></i>
															<span class="bigger-110">View more activities</span>

															<i class="icon-on-right ace-icon fa fa-arrow-right"></i>
														</button>
													</div>
												</div><!-- /#feed -->

												<div id="friends" class="tab-pane">
													<div class="profile-users clearfix">
														<div class="itemdiv memberdiv">
															<div class="inline pos-rel">
																<div class="user">
																	<a href="#">
																		<img src="assets/images/avatars/avatar4.png" alt="Bob Doe's avatar" />
																	</a>
																</div>

																<div class="body">
																	<div class="name">
																		<a href="#">
																			<span class="user-status status-online"></span>
																			Bob Doe
																		</a>
																	</div>
																</div>

																<div class="popover">
																	<div class="arrow"></div>

																	<div class="popover-content">
																		<div class="bolder">Content Editor</div>

																		<div class="time">
																			<i class="ace-icon fa fa-clock-o middle bigger-120 orange"></i>
																			<span class="green"> 20 mins ago </span>
																		</div>

																		<div class="hr dotted hr-8"></div>

																		<div class="tools action-buttons">
																			<a href="#">
																				<i class="ace-icon fa fa-facebook-square blue bigger-150"></i>
																			</a>

																			<a href="#">
																				<i class="ace-icon fa fa-twitter-square light-blue bigger-150"></i>
																			</a>

																			<a href="#">
																				<i class="ace-icon fa fa-google-plus-square red bigger-150"></i>
																			</a>
																		</div>
																	</div>
																</div>
															</div>
														</div>

														<div class="itemdiv memberdiv">
															<div class="inline pos-rel">
																<div class="user">
																	<a href="#">
																		<img src="assets/images/avatars/avatar1.png" alt="Rose Doe's avatar" />
																	</a>
																</div>

																<div class="body">
																	<div class="name">
																		<a href="#">
																			<span class="user-status status-offline"></span>
																			Rose Doe
																		</a>
																	</div>
																</div>

																<div class="popover">
																	<div class="arrow"></div>

																	<div class="popover-content">
																		<div class="bolder">Graphic Designer</div>

																		<div class="time">
																			<i class="ace-icon fa fa-clock-o middle bigger-120 grey"></i>
																			<span class="grey"> 30 min ago </span>
																		</div>

																		<div class="hr dotted hr-8"></div>

																		<div class="tools action-buttons">
																			<a href="#">
																				<i class="ace-icon fa fa-facebook-square blue bigger-150"></i>
																			</a>

																			<a href="#">
																				<i class="ace-icon fa fa-twitter-square light-blue bigger-150"></i>
																			</a>

																			<a href="#">
																				<i class="ace-icon fa fa-google-plus-square red bigger-150"></i>
																			</a>
																		</div>
																	</div>
																</div>
															</div>
														</div>

														<div class="itemdiv memberdiv">
															<div class="inline pos-rel">
																<div class="user">
																	<a href="#">
																		<img src="assets/images/avatars/avatar.png" alt="Jim Doe's avatar" />
																	</a>
																</div>

																<div class="body">
																	<div class="name">
																		<a href="#">
																			<span class="user-status status-busy"></span>
																			Jim Doe
																		</a>
																	</div>
																</div>

																<div class="popover">
																	<div class="arrow"></div>

																	<div class="popover-content">
																		<div class="bolder">SEO &amp; Advertising</div>

																		<div class="time">
																			<i class="ace-icon fa fa-clock-o middle bigger-120 red"></i>
																			<span class="grey"> 1 hour ago </span>
																		</div>

																		<div class="hr dotted hr-8"></div>

																		<div class="tools action-buttons">
																			<a href="#">
																				<i class="ace-icon fa fa-facebook-square blue bigger-150"></i>
																			</a>

																			<a href="#">
																				<i class="ace-icon fa fa-twitter-square light-blue bigger-150"></i>
																			</a>

																			<a href="#">
																				<i class="ace-icon fa fa-google-plus-square red bigger-150"></i>
																			</a>
																		</div>
																	</div>
																</div>
															</div>
														</div>

														<div class="itemdiv memberdiv">
															<div class="inline pos-rel">
																<div class="user">
																	<a href="#">
																		<img src="assets/images/avatars/avatar5.png" alt="Alex Doe's avatar" />
																	</a>
																</div>

																<div class="body">
																	<div class="name">
																		<a href="#">
																			<span class="user-status status-idle"></span>
																			Alex Doe
																		</a>
																	</div>
																</div>

																<div class="popover">
																	<div class="arrow"></div>

																	<div class="popover-content">
																		<div class="bolder">Marketing</div>

																		<div class="time">
																			<i class="ace-icon fa fa-clock-o middle bigger-120 orange"></i>
																			<span class=""> 40 minutes idle </span>
																		</div>

																		<div class="hr dotted hr-8"></div>

																		<div class="tools action-buttons">
																			<a href="#">
																				<i class="ace-icon fa fa-facebook-square blue bigger-150"></i>
																			</a>

																			<a href="#">
																				<i class="ace-icon fa fa-twitter-square light-blue bigger-150"></i>
																			</a>

																			<a href="#">
																				<i class="ace-icon fa fa-google-plus-square red bigger-150"></i>
																			</a>
																		</div>
																	</div>
																</div>
															</div>
														</div>

														<div class="itemdiv memberdiv">
															<div class="inline pos-rel">
																<div class="user">
																	<a href="#">
																		<img src="assets/images/avatars/avatar2.png" alt="Phil Doe's avatar" />
																	</a>
																</div>

																<div class="body">
																	<div class="name">
																		<a href="#">
																			<span class="user-status status-online"></span>
																			Phil Doe
																		</a>
																	</div>
																</div>

																<div class="popover">
																	<div class="arrow"></div>

																	<div class="popover-content">
																		<div class="bolder">Public Relations</div>

																		<div class="time">
																			<i class="ace-icon fa fa-clock-o middle bigger-120 orange"></i>
																			<span class="green"> 2 hours ago </span>
																		</div>

																		<div class="hr dotted hr-8"></div>

																		<div class="tools action-buttons">
																			<a href="#">
																				<i class="ace-icon fa fa-facebook-square blue bigger-150"></i>
																			</a>

																			<a href="#">
																				<i class="ace-icon fa fa-twitter-square light-blue bigger-150"></i>
																			</a>

																			<a href="#">
																				<i class="ace-icon fa fa-google-plus-square red bigger-150"></i>
																			</a>
																		</div>
																	</div>
																</div>
															</div>
														</div>

														<div class="itemdiv memberdiv">
															<div class="inline pos-rel">
																<div class="user">
																	<a href="#">
																		<img src="assets/images/avatars/avatar3.png" alt="Susan Doe's avatar" />
																	</a>
																</div>

																<div class="body">
																	<div class="name">
																		<a href="#">
																			<span class="user-status status-online"></span>
																			Susan Doe
																		</a>
																	</div>
																</div>

																<div class="popover">
																	<div class="arrow"></div>

																	<div class="popover-content">
																		<div class="bolder">HR Management</div>

																		<div class="time">
																			<i class="ace-icon fa fa-clock-o middle bigger-120 orange"></i>
																			<span class="green"> 20 mins ago </span>
																		</div>

																		<div class="hr dotted hr-8"></div>

																		<div class="tools action-buttons">
																			<a href="#">
																				<i class="ace-icon fa fa-facebook-square blue bigger-150"></i>
																			</a>

																			<a href="#">
																				<i class="ace-icon fa fa-twitter-square light-blue bigger-150"></i>
																			</a>

																			<a href="#">
																				<i class="ace-icon fa fa-google-plus-square red bigger-150"></i>
																			</a>
																		</div>
																	</div>
																</div>
															</div>
														</div>

														<div class="itemdiv memberdiv">
															<div class="inline pos-rel">
																<div class="user">
																	<a href="#">
																		<img src="assets/images/avatars/avatar1.png" alt="Jennifer Doe's avatar" />
																	</a>
																</div>

																<div class="body">
																	<div class="name">
																		<a href="#">
																			<span class="user-status status-offline"></span>
																			Jennifer Doe
																		</a>
																	</div>
																</div>

																<div class="popover">
																	<div class="arrow"></div>

																	<div class="popover-content">
																		<div class="bolder">Graphic Designer</div>

																		<div class="time">
																			<i class="ace-icon fa fa-clock-o middle bigger-120 grey"></i>
																			<span class="grey"> 2 hours ago </span>
																		</div>

																		<div class="hr dotted hr-8"></div>

																		<div class="tools action-buttons">
																			<a href="#">
																				<i class="ace-icon fa fa-facebook-square blue bigger-150"></i>
																			</a>

																			<a href="#">
																				<i class="ace-icon fa fa-twitter-square light-blue bigger-150"></i>
																			</a>

																			<a href="#">
																				<i class="ace-icon fa fa-google-plus-square red bigger-150"></i>
																			</a>
																		</div>
																	</div>
																</div>
															</div>
														</div>

														<div class="itemdiv memberdiv">
															<div class="inline pos-rel">
																<div class="user">
																	<a href="#">
																		<img src="assets/images/avatars/avatar3.png" alt="Alexa Doe's avatar" />
																	</a>
																</div>

																<div class="body">
																	<div class="name">
																		<a href="#">
																			<span class="user-status status-offline"></span>
																			Alexa Doe
																		</a>
																	</div>
																</div>

																<div class="popover">
																	<div class="arrow"></div>

																	<div class="popover-content">
																		<div class="bolder">Accounting</div>

																		<div class="time">
																			<i class="ace-icon fa fa-clock-o middle bigger-120 grey"></i>
																			<span class="grey"> 4 hours ago </span>
																		</div>

																		<div class="hr dotted hr-8"></div>

																		<div class="tools action-buttons">
																			<a href="#">
																				<i class="ace-icon fa fa-facebook-square blue bigger-150"></i>
																			</a>

																			<a href="#">
																				<i class="ace-icon fa fa-twitter-square light-blue bigger-150"></i>
																			</a>

																			<a href="#">
																				<i class="ace-icon fa fa-google-plus-square red bigger-150"></i>
																			</a>
																		</div>
																	</div>
																</div>
															</div>
														</div>
													</div>

													<div class="hr hr10 hr-double"></div>

													<ul class="pager pull-right">
														<li class="previous disabled">
															<a href="#">&larr; Prev</a>
														</li>

														<li class="next">
															<a href="#">Next &rarr;</a>
														</li>
													</ul>
												</div><!-- /#friends -->

												<div id="pictures" class="tab-pane">
													<ul class="ace-thumbnails">
														<li>
															<a href="#" data-rel="colorbox">
																<img alt="150x150" src="assets/images/gallery/thumb-1.jpg" />
																<div class="text">
																	<div class="inner">Sample Caption on Hover</div>
																</div>
															</a>

															<div class="tools tools-bottom">
																<a href="#">
																	<i class="ace-icon fa fa-link"></i>
																</a>

																<a href="#">
																	<i class="ace-icon fa fa-paperclip"></i>
																</a>

																<a href="#">
																	<i class="ace-icon fa fa-pencil"></i>
																</a>

																<a href="#">
																	<i class="ace-icon fa fa-times red"></i>
																</a>
															</div>
														</li>

														<li>
															<a href="#" data-rel="colorbox">
																<img alt="150x150" src="assets/images/gallery/thumb-2.jpg" />
																<div class="text">
																	<div class="inner">Sample Caption on Hover</div>
																</div>
															</a>

															<div class="tools tools-bottom">
																<a href="#">
																	<i class="ace-icon fa fa-link"></i>
																</a>

																<a href="#">
																	<i class="ace-icon fa fa-paperclip"></i>
																</a>

																<a href="#">
																	<i class="ace-icon fa fa-pencil"></i>
																</a>

																<a href="#">
																	<i class="ace-icon fa fa-times red"></i>
																</a>
															</div>
														</li>

														<li>
															<a href="#" data-rel="colorbox">
																<img alt="150x150" src="assets/images/gallery/thumb-3.jpg" />
																<div class="text">
																	<div class="inner">Sample Caption on Hover</div>
																</div>
															</a>

															<div class="tools tools-bottom">
																<a href="#">
																	<i class="ace-icon fa fa-link"></i>
																</a>

																<a href="#">
																	<i class="ace-icon fa fa-paperclip"></i>
																</a>

																<a href="#">
																	<i class="ace-icon fa fa-pencil"></i>
																</a>

																<a href="#">
																	<i class="ace-icon fa fa-times red"></i>
																</a>
															</div>
														</li>

														<li>
															<a href="#" data-rel="colorbox">
																<img alt="150x150" src="assets/images/gallery/thumb-4.jpg" />
																<div class="text">
																	<div class="inner">Sample Caption on Hover</div>
																</div>
															</a>

															<div class="tools tools-bottom">
																<a href="#">
																	<i class="ace-icon fa fa-link"></i>
																</a>

																<a href="#">
																	<i class="ace-icon fa fa-paperclip"></i>
																</a>

																<a href="#">
																	<i class="ace-icon fa fa-pencil"></i>
																</a>

																<a href="#">
																	<i class="ace-icon fa fa-times red"></i>
																</a>
															</div>
														</li>

														<li>
															<a href="#" data-rel="colorbox">
																<img alt="150x150" src="assets/images/gallery/thumb-5.jpg" />
																<div class="text">
																	<div class="inner">Sample Caption on Hover</div>
																</div>
															</a>

															<div class="tools tools-bottom">
																<a href="#">
																	<i class="ace-icon fa fa-link"></i>
																</a>

																<a href="#">
																	<i class="ace-icon fa fa-paperclip"></i>
																</a>

																<a href="#">
																	<i class="ace-icon fa fa-pencil"></i>
																</a>

																<a href="#">
																	<i class="ace-icon fa fa-times red"></i>
																</a>
															</div>
														</li>

														<li>
															<a href="#" data-rel="colorbox">
																<img alt="150x150" src="assets/images/gallery/thumb-6.jpg" />
																<div class="text">
																	<div class="inner">Sample Caption on Hover</div>
																</div>
															</a>

															<div class="tools tools-bottom">
																<a href="#">
																	<i class="ace-icon fa fa-link"></i>
																</a>

																<a href="#">
																	<i class="ace-icon fa fa-paperclip"></i>
																</a>

																<a href="#">
																	<i class="ace-icon fa fa-pencil"></i>
																</a>

																<a href="#">
																	<i class="ace-icon fa fa-times red"></i>
																</a>
															</div>
														</li>

														<li>
															<a href="#" data-rel="colorbox">
																<img alt="150x150" src="assets/images/gallery/thumb-1.jpg" />
																<div class="text">
																	<div class="inner">Sample Caption on Hover</div>
																</div>
															</a>

															<div class="tools tools-bottom">
																<a href="#">
																	<i class="ace-icon fa fa-link"></i>
																</a>

																<a href="#">
																	<i class="ace-icon fa fa-paperclip"></i>
																</a>

																<a href="#">
																	<i class="ace-icon fa fa-pencil"></i>
																</a>

																<a href="#">
																	<i class="ace-icon fa fa-times red"></i>
																</a>
															</div>
														</li>

														<li>
															<a href="#" data-rel="colorbox">
																<img alt="150x150" src="assets/images/gallery/thumb-2.jpg" />
																<div class="text">
																	<div class="inner">Sample Caption on Hover</div>
																</div>
															</a>

															<div class="tools tools-bottom">
																<a href="#">
																	<i class="ace-icon fa fa-link"></i>
																</a>

																<a href="#">
																	<i class="ace-icon fa fa-paperclip"></i>
																</a>

																<a href="#">
																	<i class="ace-icon fa fa-pencil"></i>
																</a>

																<a href="#">
																	<i class="ace-icon fa fa-times red"></i>
																</a>
															</div>
														</li>
													</ul>
												</div><!-- /#pictures -->
											</div>
										</div>
									</div>
								</div>

								<div class="hide">
									<div id="user-profile-3" class="user-profile row">
										<div class="col-sm-offset-1 col-sm-10">
											<div class="well well-sm">
												<!-- -
		<button type="button" class="close" data-dismiss="alert">&times;</button>
		&nbsp; -->
												<div class="inline middle blue bigger-110"> Your profile is 70% complete </div>

												&nbsp; &nbsp; &nbsp;
												<div style="width:200px;" data-percent="70%" class="inline middle no-margin progress progress-striped active pos-rel">
													<div class="progress-bar progress-bar-success" style="width:70%"></div>
												</div>
											</div><!-- /.well -->

											<div class="space"></div>

											<form class="form-horizontal">
												<div class="tabbable">
													<ul class="nav nav-tabs padding-16">
														<li class="active">
															<a data-toggle="tab" href="#edit-basic">
																<i class="green ace-icon fa fa-pencil-square-o bigger-125"></i>
																Basic Info
															</a>
														</li>

														<li>
															<a data-toggle="tab" href="#edit-settings">
																<i class="purple ace-icon fa fa-cog bigger-125"></i>
																Settings
															</a>
														</li>

														<li>
															<a data-toggle="tab" href="#edit-password">
																<i class="blue ace-icon fa fa-key bigger-125"></i>
																Password
															</a>
														</li>
													</ul>

													<div class="tab-content profile-edit-tab-content">
														<div id="edit-basic" class="tab-pane in active">
															<h4 class="header blue bolder smaller">General</h4>

															<div class="row">
																<div class="col-xs-12 col-sm-4">
																	<input type="file" />
																</div>

																<div class="vspace-12-sm"></div>

																<div class="col-xs-12 col-sm-8">
																	<div class="form-group">
																		<label class="col-sm-4 control-label no-padding-right" for="form-field-username">Username</label>

																		<div class="col-sm-8">
																			<input class="col-xs-12 col-sm-10" type="text" id="form-field-username" placeholder="Username" value="alexdoe" />
																		</div>
																	</div>

																	<div class="space-4"></div>

																	<div class="form-group">
																		<label class="col-sm-4 control-label no-padding-right" for="form-field-first">Name</label>

																		<div class="col-sm-8">
																			<input class="input-small" type="text" id="form-field-first" placeholder="First Name" value="Alex" />
																			<input class="input-small" type="text" id="form-field-last" placeholder="Last Name" value="Doe" />
																		</div>
																	</div>
																</div>
															</div>

															<hr />
															<div class="form-group">
																<label class="col-sm-3 control-label no-padding-right" for="form-field-date">Birth Date</label>

																<div class="col-sm-9">
																	<div class="input-medium">
																		<div class="input-group">
																			<input class="input-medium date-picker" id="form-field-date" type="text" data-date-format="dd-mm-yyyy" placeholder="dd-mm-yyyy" />
																			<span class="input-group-addon">
																				<i class="ace-icon fa fa-calendar"></i>
																			</span>
																		</div>
																	</div>
																</div>
															</div>

															<div class="space-4"></div>

															<div class="form-group">
																<label class="col-sm-3 control-label no-padding-right">Gender</label>

																<div class="col-sm-9">
																	<label class="inline">
																		<input name="form-field-radio" type="radio" class="ace" />
																		<span class="lbl middle"> Male</span>
																	</label>

																	&nbsp; &nbsp; &nbsp;
																	<label class="inline">
																		<input name="form-field-radio" type="radio" class="ace" />
																		<span class="lbl middle"> Female</span>
																	</label>
																</div>
															</div>

															<div class="space-4"></div>

															<div class="form-group">
																<label class="col-sm-3 control-label no-padding-right" for="form-field-comment">Comment</label>

																<div class="col-sm-9">
																	<textarea id="form-field-comment"></textarea>
																</div>
															</div>

															<div class="space"></div>
															<h4 class="header blue bolder smaller">Contact</h4>

															<div class="form-group">
																<label class="col-sm-3 control-label no-padding-right" for="form-field-email">Email</label>

																<div class="col-sm-9">
																	<span class="input-icon input-icon-right">
																		<input type="email" id="form-field-email" value="alexdoe@gmail.com" />
																		<i class="ace-icon fa fa-envelope"></i>
																	</span>
																</div>
															</div>

															<div class="space-4"></div>

															<div class="form-group">
																<label class="col-sm-3 control-label no-padding-right" for="form-field-website">Website</label>

																<div class="col-sm-9">
																	<span class="input-icon input-icon-right">
																		<input type="url" id="form-field-website" value="http://www.alexdoe.com/" />
																		<i class="ace-icon fa fa-globe"></i>
																	</span>
																</div>
															</div>

															<div class="space-4"></div>

															<div class="form-group">
																<label class="col-sm-3 control-label no-padding-right" for="form-field-phone">Phone</label>

																<div class="col-sm-9">
																	<span class="input-icon input-icon-right">
																		<input class="input-medium input-mask-phone" type="text" id="form-field-phone" />
																		<i class="ace-icon fa fa-phone fa-flip-horizontal"></i>
																	</span>
																</div>
															</div>

															<div class="space"></div>
															<h4 class="header blue bolder smaller">Social</h4>

															<div class="form-group">
																<label class="col-sm-3 control-label no-padding-right" for="form-field-facebook">Facebook</label>

																<div class="col-sm-9">
																	<span class="input-icon">
																		<input type="text" value="facebook_alexdoe" id="form-field-facebook" />
																		<i class="ace-icon fa fa-facebook blue"></i>
																	</span>
																</div>
															</div>

															<div class="space-4"></div>

															<div class="form-group">
																<label class="col-sm-3 control-label no-padding-right" for="form-field-twitter">Twitter</label>

																<div class="col-sm-9">
																	<span class="input-icon">
																		<input type="text" value="twitter_alexdoe" id="form-field-twitter" />
																		<i class="ace-icon fa fa-twitter light-blue"></i>
																	</span>
																</div>
															</div>

															<div class="space-4"></div>

															<div class="form-group">
																<label class="col-sm-3 control-label no-padding-right" for="form-field-gplus">Google+</label>

																<div class="col-sm-9">
																	<span class="input-icon">
																		<input type="text" value="google_alexdoe" id="form-field-gplus" />
																		<i class="ace-icon fa fa-google-plus red"></i>
																	</span>
																</div>
															</div>
														</div>

														<div id="edit-settings" class="tab-pane">
															<div class="space-10"></div>

															<div>
																<label class="inline">
																	<input type="checkbox" name="form-field-checkbox" class="ace" />
																	<span class="lbl"> Make my profile public</span>
																</label>
															</div>

															<div class="space-8"></div>

															<div>
																<label class="inline">
																	<input type="checkbox" name="form-field-checkbox" class="ace" />
																	<span class="lbl"> Email me new updates</span>
																</label>
															</div>

															<div class="space-8"></div>

															<div>
																<label>
																	<input type="checkbox" name="form-field-checkbox" class="ace" />
																	<span class="lbl"> Keep a history of my conversations</span>
																</label>

																<label>
																	<span class="space-2 block"></span>

																	for
																	<input type="text" class="input-mini" maxlength="3" />
																	days
																</label>
															</div>
														</div>

														<div id="edit-password" class="tab-pane">
															<div class="space-10"></div>

															<div class="form-group">
																<label class="col-sm-3 control-label no-padding-right" for="form-field-pass1">New Password</label>

																<div class="col-sm-9">
																	<input type="password" id="form-field-pass1" />
																</div>
															</div>

															<div class="space-4"></div>

															<div class="form-group">
																<label class="col-sm-3 control-label no-padding-right" for="form-field-pass2">Confirm Password</label>

																<div class="col-sm-9">
																	<input type="password" id="form-field-pass2" />
																</div>
															</div>
														</div>
													</div>
												</div>

												<div class="clearfix form-actions">
													<div class="col-md-offset-3 col-md-9">
														<button class="btn btn-info" type="button">
															<i class="ace-icon fa fa-check bigger-110"></i>
															Save
														</button>

														&nbsp; &nbsp;
														<button class="btn" type="reset">
															<i class="ace-icon fa fa-undo bigger-110"></i>
															Reset
														</button>
													</div>
												</div>
											</form>
										</div><!-- /.span -->
									</div><!-- /.user-profile -->
								</div>
								

								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
					</div><!-- /.page-content -->
				</div>
			</div><!-- /.main-content -->

			<div class="footer">
				<div class="footer-inner">
					<div class="footer-content">
						<span class="bigger-120">
							<span class="blue bolder">Smart Shopper </span>
							 &copy; <%=new Date()%>
						</span>

						&nbsp; &nbsp;
						<span class="action-buttons">
							<a href="#">
								<i class="ace-icon fa fa-twitter-square light-blue bigger-150"></i>
							</a>

							<a href="#">
								<i class="ace-icon fa fa-facebook-square text-primary bigger-150"></i>
							</a>

							<a href="#">
								<i class="ace-icon fa fa-instagram orange bigger-150"></i>
							</a>
						</span>
					</div>
				</div>
			</div>

			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
			</a>
		</div><!-- /.main-container -->

		<!-- basic scripts -->

		<!--[if !IE]> -->
		<script src="assets/js/jquery-2.1.4.min.js"></script>

		<!-- <![endif]-->

		<!--[if IE]>
<script src="assets/js/jquery-1.11.3.min.js"></script>
<![endif]-->
		<script type="text/javascript">
			if('ontouchstart' in document.documentElement) document.write("<script src='assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
		<script src="assets/js/bootstrap.min.js"></script>

		<!-- page specific plugin scripts -->

		<!--[if lte IE 8]>
		  <script src="assets/js/excanvas.min.js"></script>
		<![endif]-->
		<script src="assets/js/jquery-ui.custom.min.js"></script>
		<script src="assets/js/jquery.ui.touch-punch.min.js"></script>
		<script src="assets/js/jquery.easypiechart.min.js"></script>
		<script src="assets/js/jquery.sparkline.index.min.js"></script>
		<script src="assets/js/jquery.flot.min.js"></script>
		<script src="assets/js/jquery.flot.pie.min.js"></script>
		<script src="assets/js/jquery.flot.resize.min.js"></script>

		<!-- ace scripts -->
		<script src="assets/js/ace-elements.min.js"></script>
		<script src="assets/js/ace.min.js"></script>

		<!-- inline scripts related to this page -->
		<script type="text/javascript">
			jQuery(function($) {
				$('.easy-pie-chart.percentage').each(function(){
					var $box = $(this).closest('.infobox');
					var barColor = $(this).data('color') || (!$box.hasClass('infobox-dark') ? $box.css('color') : 'rgba(255,255,255,0.95)');
					var trackColor = barColor == 'rgba(255,255,255,0.95)' ? 'rgba(255,255,255,0.25)' : '#E2E2E2';
					var size = parseInt($(this).data('size')) || 50;
					$(this).easyPieChart({
						barColor: barColor,
						trackColor: trackColor,
						scaleColor: false,
						lineCap: 'butt',
						lineWidth: parseInt(size/10),
						animate: ace.vars['old_ie'] ? false : 1000,
						size: size
					});
				})
			
				$('.sparkline').each(function(){
					var $box = $(this).closest('.infobox');
					var barColor = !$box.hasClass('infobox-dark') ? $box.css('color') : '#FFF';
					$(this).sparkline('html',
									 {
										tagValuesAttribute:'data-values',
										type: 'bar',
										barColor: barColor ,
										chartRangeMin:$(this).data('min') || 0
									 });
				});
			
			
			  //flot chart resize plugin, somehow manipulates default browser resize event to optimize it!
			  //but sometimes it brings up errors with normal resize event handlers
			  $.resize.throttleWindow = false;
			
			  var placeholder = $('#piechart-placeholder').css({'width':'90%' , 'min-height':'150px'});
			  var data = [
				{ label: "social networks",  data: 38.7, color: "#68BC31"},
				{ label: "search engines",  data: 24.5, color: "#2091CF"},
				{ label: "ad campaigns",  data: 8.2, color: "#AF4E96"},
				{ label: "direct traffic",  data: 18.6, color: "#DA5430"},
				{ label: "other",  data: 10, color: "#FEE074"}
			  ]
			  function drawPieChart(placeholder, data, position) {
			 	  $.plot(placeholder, data, {
					series: {
						pie: {
							show: true,
							tilt:0.8,
							highlight: {
								opacity: 0.25
							},
							stroke: {
								color: '#fff',
								width: 2
							},
							startAngle: 2
						}
					},
					legend: {
						show: true,
						position: position || "ne", 
						labelBoxBorderColor: null,
						margin:[-30,15]
					}
					,
					grid: {
						hoverable: true,
						clickable: true
					}
				 })
			 }
			 drawPieChart(placeholder, data);
			
			 /**
			 we saved the drawing function and the data to redraw with different position later when switching to RTL mode dynamically
			 so that's not needed actually.
			 */
			 placeholder.data('chart', data);
			 placeholder.data('draw', drawPieChart);
			
			
			  //pie chart tooltip example
			  var $tooltip = $("<div class='tooltip top in'><div class='tooltip-inner'></div></div>").hide().appendTo('body');
			  var previousPoint = null;
			
			  placeholder.on('plothover', function (event, pos, item) {
				if(item) {
					if (previousPoint != item.seriesIndex) {
						previousPoint = item.seriesIndex;
						var tip = item.series['label'] + " : " + item.series['percent']+'%';
						$tooltip.show().children(0).text(tip);
					}
					$tooltip.css({top:pos.pageY + 10, left:pos.pageX + 10});
				} else {
					$tooltip.hide();
					previousPoint = null;
				}
				
			 });
			
				/////////////////////////////////////
				$(document).one('ajaxloadstart.page', function(e) {
					$tooltip.remove();
				});
			
			
			
			
				var d1 = [];
				for (var i = 0; i < Math.PI * 2; i += 0.5) {
					d1.push([i, Math.sin(i)]);
				}
			
				var d2 = [];
				for (var i = 0; i < Math.PI * 2; i += 0.5) {
					d2.push([i, Math.cos(i)]);
				}
			
				var d3 = [];
				for (var i = 0; i < Math.PI * 2; i += 0.2) {
					d3.push([i, Math.tan(i)]);
				}
				
			
				var sales_charts = $('#sales-charts').css({'width':'100%' , 'height':'220px'});
				$.plot("#sales-charts", [
					{ label: "Domains", data: d1 },
					{ label: "Hosting", data: d2 },
					{ label: "Services", data: d3 }
				], {
					hoverable: true,
					shadowSize: 0,
					series: {
						lines: { show: true },
						points: { show: true }
					},
					xaxis: {
						tickLength: 0
					},
					yaxis: {
						ticks: 10,
						min: -2,
						max: 2,
						tickDecimals: 3
					},
					grid: {
						backgroundColor: { colors: [ "#fff", "#fff" ] },
						borderWidth: 1,
						borderColor:'#555'
					}
				});
			
			
				$('#recent-box [data-rel="tooltip"]').tooltip({placement: tooltip_placement});
				function tooltip_placement(context, source) {
					var $source = $(source);
					var $parent = $source.closest('.tab-content')
					var off1 = $parent.offset();
					var w1 = $parent.width();
			
					var off2 = $source.offset();
					//var w2 = $source.width();
			
					if( parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2) ) return 'right';
					return 'left';
				}
			
			
				$('.dialogs,.comments').ace_scroll({
					size: 300
			    });
				
				
				//Android's default browser somehow is confused when tapping on label which will lead to dragging the task
				//so disable dragging when clicking on label
				var agent = navigator.userAgent.toLowerCase();
				if(ace.vars['touch'] && ace.vars['android']) {
				  $('#tasks').on('touchstart', function(e){
					var li = $(e.target).closest('#tasks li');
					if(li.length == 0)return;
					var label = li.find('label.inline').get(0);
					if(label == e.target || $.contains(label, e.target)) e.stopImmediatePropagation() ;
				  });
				}
			
				$('#tasks').sortable({
					opacity:0.8,
					revert:true,
					forceHelperSize:true,
					placeholder: 'draggable-placeholder',
					forcePlaceholderSize:true,
					tolerance:'pointer',
					stop: function( event, ui ) {
						//just for Chrome!!!! so that dropdowns on items don't appear below other items after being moved
						$(ui.item).css('z-index', 'auto');
					}
					}
				);
				$('#tasks').disableSelection();
				$('#tasks input:checkbox').removeAttr('checked').on('click', function(){
					if(this.checked) $(this).closest('li').addClass('selected');
					else $(this).closest('li').removeClass('selected');
				});
			
			
				//show the dropdowns on top or bottom depending on window height and menu position
				$('#task-tab .dropdown-hover').on('mouseenter', function(e) {
					var offset = $(this).offset();
			
					var $w = $(window)
					if (offset.top > $w.scrollTop() + $w.innerHeight() - 100) 
						$(this).addClass('dropup');
					else $(this).removeClass('dropup');
				});
			
			})
		</script>
	</body>
</html>

