-- MySQL dump 10.13  Distrib 8.0.43, for Linux (x86_64)
--
-- Host: localhost    Database: react_components_db
-- ------------------------------------------------------
-- Server version	8.0.43-0ubuntu0.22.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `authorities`
--

DROP TABLE IF EXISTS `authorities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
  CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authorities`
--

LOCK TABLES `authorities` WRITE;
/*!40000 ALTER TABLE `authorities` DISABLE KEYS */;
INSERT INTO `authorities` VALUES ('john','ROLE_EMPLOYEE'),('mary','ROLE_EMPLOYEE'),('mary','ROLE_MANAGER'),('susan','ROLE_ADMIN'),('susan','ROLE_EMPLOYEE'),('susan','ROLE_MANAGER');
/*!40000 ALTER TABLE `authorities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categories` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,'All','sdfgdfgdfsg'),(2,'Cards','rrrrrrrrrrrrrr'),(3,'Buttons','ddddddd'),(4,'Text','dfsgdfgsdgdfgdf'),(5,'Text Animations','Text effects with animations'),(6,'Backgrounds','Background effects and layouts'),(7,'Carousels','Carousel and slider components'),(8,'Media Galleries','Media and image gallery components'),(9,'Navigation','Menus and navigation bars'),(10,'Loaders','Loading animations and spinners'),(11,'Accordions','Accordion and collapsible panels'),(12,'Images','sadf'),(13,'3D & Canvas','3D effects and canvas components'),(14,'Data & Tables','Tables, lists, and data views'),(15,'Forms & Inputs','Form elements and input fields'),(16,'Cursor & Pointer Effects','Interactive cursor effects'),(17,'Special Effects & FX','Extra visual effects'),(18,'Utilities','Utility components and tools'),(19,'Videos','Video players and related components'),(20,'Testimonials','Testimonial display components'),(21,'Grids & Layouts','Grid systems and layout helpers');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `components`
--

DROP TABLE IF EXISTS `components`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `components` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `categories` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=279 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `components`
--

LOCK TABLES `components` WRITE;
/*!40000 ALTER TABLE `components` DISABLE KEYS */;
INSERT INTO `components` VALUES (1,'3d-card','A UI card component for displaying content: 3D Card.','[1, 2, 13]'),(2,'3d-nav-bar','A navigation/menu component: 3D Nav Bar.','[1, 9]'),(3,'accordion-slices','An accordion/collapsible component: Accordion Slices.','[1, 11]'),(4,'action-search-bar','A form/input component: Action Search Bar.','[1, 15]'),(5,'animated-accordion','An accordion/collapsible component: Animated Accordion.','[1, 11]'),(6,'animated-hover-card','A UI card component with hover animations: Animated Hover Card.','[1, 2]'),(7,'animated-list','A React component called Animated List.','[1, 17]'),(8,'ascii-converter','A utility component: Ascii Converter.','[1, 18]'),(9,'attractor','A 3D & Canvas component: Attractor.','[1, 13]'),(10,'aurora-background','A visual background effect component: Aurora Background.','[1, 6, 17]'),(11,'award-carousel','A carousel/slider component for images or content: Award Carousel.','[1, 7]'),(12,'background-beams','A visual background effect component: Background Beams.','[1, 6]'),(13,'background-boxes','A visual background effect component: Background Boxes.','[1, 6]'),(14,'background-gradient','A visual background effect component: Background Gradient.','[1, 6]'),(15,'background','A visual background effect component: Background.','[1, 6]'),(16,'ballpit','A React component called Ballpit.','[1, 17]'),(17,'bento','A React component called Bento.','[1, 17]'),(18,'blur-vignette','A visual background effect component: Blur Vignette.','[1, 6]'),(19,'book-testimonials','A testimonial display component: Book Testimonials.','[1, 20]'),(20,'bottom-blur','A visual background effect component: Bottom Blur.','[1, 6]'),(21,'btn08','An interactive button component: Btn08.','[1, 3]'),(22,'bubble-text','A text/typography effect component: Bubble Text.','[1, 4]'),(23,'business-footer','A React component called Business Footer.','[1]'),(24,'canvas-reveal','A 3D & Canvas component: Canvas Reveal.','[1, 13]'),(25,'card-deck','A UI card component for displaying content: Card Deck.','[1, 2]'),(26,'card-hover','A UI card component with hover animations: Card Hover.','[1, 2, 17]'),(27,'card-rotation','A UI card component with rotation effect: Card Rotation.','[1, 2]'),(28,'card-stack','A UI card component arranged in a stack: Card Stack.','[1, 2]'),(29,'card-swap','A UI card component with swap animation: Card Swap.','[1, 2]'),(30,'cards','A UI card component for displaying multiple cards: Cards.','[1, 2]'),(31,'carousel-circle','A carousel/slider component: Carousel Circle.','[1, 7]'),(32,'carousel-stack','A carousel/slider component: Carousel Stack.','[1, 7]'),(33,'checkbox-animated','A form/input component: Checkbox Animated.','[1, 15]'),(34,'chroma-grid','A grid/layout component: Chroma Grid.','[1, 21]'),(35,'cielia-replication','A React component called Cielia Replication.','[1]'),(36,'circle-accordion','An accordion/collapsible component: Circle Accordion.','[1, 11]'),(37,'circle-text','A text/typography effect component: Circle Text.','[1, 4]'),(38,'circuit-board','A React component called Circuit Board.','[1]'),(39,'circular-bars-loader','A loading animation component: Circular Bars Loader.','[1, 10]'),(40,'code-block','A React component called Code Block.','[1]'),(41,'color-change-cards','A UI card component with color changing effect: Color Change Cards.','[1, 2]'),(42,'color-picker','A form/input component: Color Picker.','[1, 15]'),(43,'colorful-text','A text/typography effect component: Colorful Text.','[1, 4]'),(44,'compare','A React component called Compare.','[1]'),(45,'container-scroll','A React component called Container Scroll.','[1]'),(46,'content-with-image','A React component called Content With Image.','[1]'),(47,'css-box','A React component called Css Box.','[1]'),(48,'cubes','A 3D & Canvas component: Cubes.','[1, 13]'),(49,'cursor-carousel','A cursor/pointer effect component: Cursor Carousel.','[1, 16]'),(50,'cursor-follow','A cursor/pointer effect component: Cursor Follow.','[1, 16]'),(51,'cursor-mask','A cursor/pointer effect component: Cursor Mask.','[1, 16]'),(52,'curved-navbar','A navigation/menu component: Curved Navbar.','[1, 9]'),(53,'dark-veil','A visual background effect component: Dark Veil.','[1, 6]'),(54,'dialog-stack','A React component called Dialog Stack.','[1]'),(55,'diamond-gallery','A React component called Diamond Gallery.','[1]'),(56,'dither','A React component called Dither.','[1]'),(57,'dual-ring-loader','A loading animation component: Dual Ring Loader.','[1, 10]'),(58,'dynamic-island','A React component called Dynamic Island.','[1]'),(59,'dynamic-theme','A React component called Dynamic Theme.','[1]'),(60,'editor','A utility component: Editor.','[1, 18]'),(61,'elastic-line','A React component called Elastic Line.','[1, 17]'),(62,'electric-border','A React component called Electric Border.','[1, 17]'),(63,'expanding-tabs','A React component called Expanding Tabs.','[1]'),(64,'falling-text','A text/typography effect component: Falling Text.','[1, 4]'),(65,'fancy-input','A form/input component: Fancy Input.','[1, 15]'),(66,'faq-section','An accordion/collapsible component: Faq Section.','[1, 11]'),(67,'faulty-terminal','A React component called Faulty Terminal.','[1]'),(68,'feature','A React component called Feature.','[1]'),(69,'film-reel','A media/gallery component: Film Reel.','[1, 8]'),(70,'fishy-button','An interactive button component: Fishy Button.','[1, 3]'),(71,'flip-card','A UI card component with flipping effect: Flip Card.','[1, 2]'),(72,'flipped-menu','A React component called Flipped Menu.','[1]'),(73,'flipping-text','A text/typography effect component: Flipping Text.','[1, 5]'),(74,'floating-dock','A React component called Floating Dock.','[1, 17]'),(75,'floating-nav','A navigation/menu component: Floating Nav.','[1, 9]'),(76,'flower-menu','A navigation/menu component: Flower Menu.','[1, 9]'),(77,'flowing-nav','A navigation/menu component: Flowing Nav.','[1, 9]'),(78,'fluid-glass','A React component called Fluid Glass.','[1]'),(79,'fluid-morph','A React component called Fluid Morph.','[1]'),(80,'focus-cards','A UI card component focused on content: Focus Cards.','[1, 2]'),(81,'fold-hover-button','An interactive button component: Fold Hover Button.','[1, 3]'),(82,'folder','A React component called Folder.','[1]'),(83,'follow-cursor','A cursor/pointer effect component: Follow Cursor.','[1, 16]'),(84,'following-eyes','A cursor/pointer effect component: Following Eyes.','[1, 16]'),(85,'following-headers','A React component called Following Headers.','[1]'),(86,'following-pointer','A cursor/pointer effect component: Following Pointer.','[1, 16]'),(87,'fractal-grid','A grid/layout component: Fractal Grid.','[1, 21]'),(88,'frequency','A React component called Frequency.','[1]'),(89,'fullscreen-image','An image/media display component: Fullscreen Image.','[1, 12]'),(90,'fuzzy-overlay','A React component called Fuzzy Overlay.','[1, 17]'),(91,'fuzzy-text','A text/typography effect component: Fuzzy Text.','[1, 4]'),(92,'galaxy-button','An interactive button component: Galaxy Button.','[1, 3]'),(93,'ghost-label','A React component called Ghost Label.','[1]'),(94,'gif-text','A text/typography effect component: Gif Text.','[1, 4]'),(95,'glass-nav','A navigation/menu component: Glass Nav.','[1, 9]'),(96,'globe','A 3D & Canvas component: Globe.','[1, 13]'),(97,'glowing-background','A visual background effect component: Glowing Background.','[1, 6, 17]'),(98,'glowing-effect','A React component called Glowing Effect.','[1, 17]'),(99,'gooey-tabs','A React component called Gooey Tabs.','[1]'),(100,'gradient-background','A visual background effect component: Gradient Background.','[1, 6]'),(101,'gradient-checkbox','A form/input component: Gradient Checkbox.','[1, 15]'),(102,'gradient-testimonials','A testimonial display component: Gradient Testimonials.','[1, 20]'),(103,'gravity','A React component called Gravity.','[1]'),(104,'grid-content','A React component called Grid Content.','[1]'),(105,'grid-distortion','A React component called Grid Distortion.','[1]'),(106,'grid-to-flex','A grid/layout component: Grid To Flex.','[1, 21]'),(107,'half-filled-text','A text/typography effect component: Half Filled Text.','[1, 4]'),(108,'hero-highlight','A text/typography effect component: Hero Highlight.','[1, 4]'),(109,'hero-parallax','A React component called Hero Parallax.','[1]'),(110,'horizontal-cta','An interactive button component: Horizontal CTA.','[1, 3]'),(111,'horizontal-scroll-gallery','A navigation/menu component: Horizontal Scroll Gallery.','[1, 9]'),(112,'hover-border','An interactive button component: Hover Border.','[1, 3]'),(113,'hover-card','A UI card component with hover effect: Hover Card.','[1, 2]'),(114,'hover-cards','A UI card component with multiple hover effects: Hover Cards.','[1, 2]'),(115,'hover-gallery','A React component called Hover Gallery.','[1]'),(116,'hover-squares','A React component called Hover Squares.','[1]'),(117,'hover','A React component called Hover.','[1]'),(118,'icons','A React component called Icons.','[1]'),(119,'image-reveal','An image/media display component: Image Reveal.','[1, 12]'),(120,'image-ripple','An image/media display component: Image Ripple.','[1, 12]'),(121,'image-wheel','An image/media display component: Image Wheel.','[1, 12, 8]'),(122,'image-zoom','An image/media display component: Image Zoom.','[1, 12]'),(123,'infinite-carousel','A carousel/slider component: Infinite Carousel.','[1, 7]'),(124,'infinite-menu','A React component called Infinite Menu.','[1]'),(125,'infinite-moving-cards','A media/gallery component: Infinite Moving Cards.','[1, 8]'),(126,'infinite-scrolling-logos-animation','A media/gallery component: Infinite Scrolling Logos Animation.','[1, 8]'),(127,'info-card','A UI card component displaying info: Info Card.','[1, 2]'),(128,'inner-glow','A React component called Inner Glow.','[1, 17]'),(129,'input-animated','A form/input component: Input Animated.','[1, 15]'),(130,'lamp','A React component called Lamp.','[1]'),(131,'lane-card','A UI card component: Lane Card.','[1, 2]'),(132,'lanyard','A React component called Lanyard.','[1]'),(133,'layout-grid','A grid/layout component: Layout Grid.','[1, 21]'),(134,'lens','A 3D & Canvas component: Lens.','[1, 13]'),(135,'letter-hover','A text/typography effect component: Letter Hover.','[1, 4]'),(136,'letter3d-swap','A text animation component: Letter3D Swap.','[1, 5]'),(137,'light-rays','A visual background effect component: Light Rays.','[1, 6]'),(138,'line-background','A visual background effect component: Line Background.','[1, 6]'),(139,'linear-dialog','A React component called Linear Dialog.','[1]'),(140,'link-preview','A React component called Link Preview.','[1]'),(141,'list-rotator','A data display component: List Rotator.','[1, 14]'),(142,'logo-loop','A React component called Logo Loop.','[1]'),(143,'logo-particles','A React component called Logo Particles.','[1]'),(144,'macbook','A React component called MacBook.','[1]'),(145,'magic-bento','A React component called Magic Bento.','[1]'),(146,'magnet-lines','A React component called Magnet Lines.','[1, 17]'),(147,'marquee-along-svg','A media/gallery component: Marquee Along SVG.','[1, 8]'),(148,'mask-effect','A React component called Mask Effect.','[1]'),(149,'masonry','A grid/layout component: Masonry.','[1, 21]'),(150,'matrix-background','A visual background effect component: Matrix Background.','[1, 6]'),(151,'media-between-text','An image/media display component: Media Between Text.','[1, 12]'),(152,'meteors','A React component called Meteors.','[1]'),(153,'mobile-nav-basic','A navigation/menu component: Mobile Nav Basic.','[1, 9]'),(154,'mobile-nav','A navigation/menu component: Mobile Nav.','[1, 9]'),(155,'model-viewer','A 3D & Canvas component: Model Viewer.','[1, 13]'),(156,'mouse-image-trail','A React component called Mouse Image Trail.','[1]'),(157,'movie-gallery','A media/gallery component: Movie Gallery.','[1, 8]'),(158,'nav-bar','A navigation/menu component: Nav Bar.','[1, 9]'),(159,'navbar2','A navigation/menu component: Navbar2.','[1, 9]'),(160,'navbar3','A navigation/menu component: Navbar3.','[1, 9]'),(161,'navigation','A navigation/menu component: Navigation.','[1, 9]'),(162,'nine-dot-loader','A loading animation component: Nine Dot Loader.','[1, 10]'),(163,'number-ticker','A data display component: Number Ticker.','[1, 14]'),(164,'opposite-scroll-links','A React component called Opposite Scroll Links.','[1]'),(165,'opposite-scroll','A React component called Opposite Scroll.','[1]'),(166,'page-transitions','A React component called Page Transitions.','[1]'),(167,'parallax-carousel','A carousel/slider component: Parallax Carousel.','[1, 7]'),(168,'parallax-floating','A React component called Parallax Floating.','[1]'),(169,'parallax-scroll','A React component called Parallax Scroll.','[1]'),(170,'peel-reveal','A React component called Peel Reveal.','[1, 17]'),(171,'pin','A React component called Pin.','[1]'),(172,'ping-pong','A React component called Ping Pong.','[1]'),(173,'pipeline','A utility component: Pipeline.','[1, 18]'),(174,'pixel-image','An image/media display component: Pixel Image.','[1, 12]'),(175,'pointer','A cursor/pointer effect component: Pointer.','[1, 16]'),(176,'popular-price-card','A UI card component: Popular Price Card.','[1, 2]'),(177,'position-aware-button','An interactive button component: Position Aware Button.','[1, 3]'),(178,'power-off-slide','A React component called Power Off Slide.','[1]'),(179,'preloader','A loading animation component: Preloader.','[1, 10]'),(180,'price-card','A UI card component: Price Card.','[1, 2]'),(181,'pricing-table','A React component called Pricing Table.','[1]'),(182,'progress-carousel','A carousel/slider component: Progress Carousel.','[1, 7]'),(183,'progressive-blur','A visual background effect component: Progressive Blur.','[1, 6]'),(184,'project-showcase','A React component called Project Showcase.','[1]'),(185,'random-letter-swap-hover','A text animation effect component: Random Letter Swap Hover.','[1, 5]'),(186,'resize-navbar','A React component called Resize Navbar.','[1]'),(187,'rich-popover','A React component called Rich Popover.','[1]'),(188,'rounded-scrollbar','A React component called Rounded Scrollbar.','[1]'),(189,'sandbox','A utility component: Sandbox.','[1, 18]'),(190,'scaling-button','An interactive button component: Scaling Button.','[1, 3]'),(191,'screen-saver','A React component called Screen Saver.','[1]'),(192,'scroll-float','A React component called Scroll Float.','[1]'),(193,'scroll-horizontal-2','A React component called Scroll Horizontal 2.','[1]'),(194,'scroll-horizontal','A React component called Scroll Horizontal.','[1]'),(195,'scroll-island','A React component called Scroll Island.','[1]'),(196,'scroll-reveal-paragraph','A React component called Scroll Reveal Paragraph.','[1]'),(197,'scroll-reveal','A React component called Scroll Reveal.','[1]'),(198,'scroll-velocity','A React component called Scroll Velocity.','[1]'),(199,'scrollable-card-stack','A UI card component arranged in a scrollable stack: Scrollable Card Stack.','[1, 2]'),(200,'searchbar','A form/input component: Searchbar.','[1, 15]'),(201,'select-modal','A form/input component: Select Modal.','[1, 15]'),(202,'services','A React component called Services.','[1]'),(203,'shape-blur','A visual background effect component: Shape Blur.','[1, 6]'),(204,'share-button','An interactive button component: Share Button.','[1, 3]'),(205,'shuffle-hero','A React component called Shuffle Hero.','[1]'),(206,'sidebar','A navigation/menu component: Sidebar.','[1, 9]'),(207,'sideivdeo','A React component called Sideivdeo.','[1]'),(208,'simple-footer','A React component called Simple Footer.','[1]'),(209,'simple-grid','A grid/layout component: Simple Grid.','[1]'),(210,'skeleton','A React component called Skeleton.','[1]'),(211,'slice-accordion','An accordion/collapsible component: Slice Accordion.','[1, 11]'),(212,'slide-button','An interactive button component: Slide Button.','[1, 3]'),(213,'sliding-numbers','A React component called Sliding Numbers.','[1]'),(214,'smokey-cursor','A cursor/pointer effect component: Smokey Cursor.','[1, 16]'),(215,'smooth-cursor','A cursor/pointer effect component: Smooth Cursor.','[1, 16]'),(216,'smooth-slider','A React component called Smooth Slider.','[1]'),(217,'snowflakes','A React component called Snowflakes.','[1]'),(218,'social-links','A React component called Social Links.','[1]'),(219,'sparkles','A React component called Sparkles.','[1, 17]'),(220,'spinner','A loading animation component: Spinner.','[1, 10]'),(221,'spotlight','A React component called Spotlight.','[1, 17]'),(222,'spring-element','A React component called Spring Element.','[1, 17]'),(223,'spring-faq','An accordion/collapsible component: Spring FAQ.','[1, 11]'),(224,'spring-modal','A React component called Spring Modal.','[1]'),(225,'stacked-carousel','A carousel/slider component: Stacked Carousel.','[1, 7]'),(226,'stacking-cards','A UI card component arranged in a stack: Stacking Cards.','[1, 2]'),(227,'starfield-wrapper','A React component called Starfield Wrapper.','[1]'),(228,'sticker-peel','A React component called Sticker Peel.','[1]'),(229,'sticky-scroll-reveal','A React component called Sticky Scroll Reveal.','[1]'),(230,'stripe-accordion','An accordion/collapsible component: Stripe Accordion.','[1, 11]'),(231,'stripes-preloader','A loading animation component: Stripes Preloader.','[1, 10]'),(232,'swap-column-features','A React component called Swap Column Features.','[1]'),(233,'table','A data display component: Table.','[1, 14]'),(234,'tabs-transition-panel','A React component called Tabs Transition Panel.','[1]'),(235,'tabs','A navigation/menu component: Tabs.','[1, 9]'),(236,'target-cursor','A cursor/pointer effect component: Target Cursor.','[1, 16]'),(237,'terminal','A React component called Terminal.','[1]'),(238,'text-along-path','A text/typography animation component: Text Along Path.','[1, 4, 5]'),(239,'text-animate','A text/typography animation component: Text Animate.','[1, 5]'),(240,'text-cursor','A text/typography animation component: Text Cursor.','[1, 4, 5]'),(241,'text-curve','A text/typography effect component: Text Curve.','[1, 4]'),(242,'text-enhanced','A text/typography effect component: Text Enhanced.','[1, 4]'),(243,'text-focus','A text/typography effect component: Text Focus.','[1, 4]'),(244,'text-gradient','A text/typography effect component: Text Gradient.','[1, 4]'),(245,'text-highlighter','A text/typography effect component: Text Highlighter.','[1, 4]'),(246,'text-hover','A text/typography effect component: Text Hover.','[1, 4]'),(247,'text-morph','A text/typography animation component: Text Morph.','[1, 4, 5]'),(248,'text-parallax-content','A text/typography effect component: Text Parallax Content.','[1, 4]'),(249,'text-proximity','A text/typography effect component: Text Proximity.','[1, 4]'),(250,'text-reveal','A text/typography animation component: Text Reveal.','[1, 4, 5]'),(251,'text-roll','A text/typography animation component: Text Roll.','[1, 4, 5]'),(252,'text-rotate','A text/typography animation component: Text Rotate.','[1, 4, 5]'),(253,'text-split','A text/typography animation component: Text Split.','[1, 4, 5]'),(254,'text-trail','A text/typography animation component: Text Trail.','[1, 4, 5]'),(255,'text-type','A text/typography animation component: Text Type.','[1, 4, 5]'),(256,'text-underline','A text/typography effect component: Text Underline.','[1, 4, 5]'),(257,'theme-animations','A React component called Theme Animations.','[1]'),(258,'threads','A React component called Threads.','[1]'),(259,'three-bounce-loader','A loading animation component: Three Bounce Loader.','[1, 10]'),(260,'three-dot-loader','A loading animation component: Three Dot Loader.','[1, 10]'),(261,'tiles-background','A visual background effect component: Tiles Background.','[1, 6]'),(262,'timeline','A React component called Timeline.','[1]'),(263,'tool-tip','A utility component: Tool Tip.','[1, 18]'),(264,'tour','A React component called Tour.','[1]'),(265,'tracing-beam','A special effect component: Tracing Beam.','[1, 17]'),(266,'tunnel','A special effect component: Tunnel.','[1, 17]'),(267,'typewriter-testimonials','A testimonial display component: Typewriter Testimonials.','[1, 20]'),(268,'underline-to-background','A React component called Underline To Background.','[1]'),(269,'vertical-cut-reveal','A React component called Vertical Cut Reveal.','[1]'),(270,'video-button','An interactive button component: Video Button.','[1, 3]'),(271,'video-hero','A video component: Video Hero.','[1, 19]'),(272,'video-player','A video component: Video Player.','[1, 19]'),(273,'video-player2','A video component: Video Player 2.','[1, 19]'),(274,'video-viewer','A video component: Video Viewer.','[1, 19]'),(275,'view-list','A data display component: View List.','[1, 14]'),(276,'wobble-card','A UI card component with wobble effect: Wobble Card.','[1, 2, 17]'),(277,'word-tornado','A React component called Word Tornado.','[1]'),(278,'zoom-blur-card','A UI card component with zoom blur effect: Zoom Blur Card.','[1, 2]');
/*!40000 ALTER TABLE `components` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'dsajdfonsdasdfkiafd@sdafayeu','duck;','dddd'),(2,'dsajdfonsdasdfkiafd@sdafayeu','duck;','dddd'),(3,'dsajdfonsdasdfkiafd@sdafayeu','duck;','dddd'),(4,'dsajdfonsdasdfkiafd@sdafayeu','duck;','dddd'),(5,'dsajdfonsdasdfkiafd@sdafayeu','duck;','dddd'),(6,'dsajdfonsdasdfkiafd@sdafayeu','duck;','dddd'),(7,'dsajdfonsdasdfkiafd@sdafayeu','duck;','dddd'),(8,'dsajdfonsdasdfkiafd@sdafayeu','duck;','dddd'),(9,'dsajdfonsdasdfkiafd@sdafayeu','duck;','dddd'),(10,'dsajdfonsdasdfkiafd@sdafayeu','duck;','dddd'),(11,'dsajdfonsdasdfkiafd@sdafayeu','duck;','dddd'),(12,'dsajdfonsdasdfkiafd@sdafayeu','duck;','dddd'),(13,'dsajdfonsdasdfkiafd@sdafayeu','duck;','dddd'),(14,'dsajdfonsdasdfkiafd@sdafayeu','duck;','dddd'),(15,'dsajdfonsdasdfkiafd@sdafayeu','duck;','dddd'),(16,'dsajdfonsdasdfkiafd@sdafayeu','duck;','dddd'),(17,'dsajdfonsdasdfkiafd@sdafayeu','duck;','dddd'),(18,'dsajdfonsdasdfkiafd@sdafayeu','duck;','dddd'),(19,'dsajdfonsdasdfkiafd@sdafayeu','duck;','dddd'),(20,'dsajdfonsdasdfkiafd@sdafayeu','duck;','dddd'),(21,'dsajdfonsdasdfkiafd@sdafayeu','duck;','dddd'),(22,'dsajdfonsdasdfkiafd@sdafayeu','duck;','dddd'),(23,'dsajdfonsdasdfkiafd@sdafayeu','duck;','dddd'),(24,'dsajdfonsdasdfkiafd@sdafayeu','duck;','dddd'),(25,'dsajdfonsdasdfkiafd@sdafayeu','duck;','dddd'),(26,'dsajdfonsdasdfkiafd@sdafayeu','duck;','dddd'),(27,'dsajdfonsdasdfkiafd@sdafayeu','duck;','dddd'),(28,'dsajdfonsdasdfkiafd@sdafayeu','duck;','dddd'),(29,'dsajdfonsdasdfkiafd@sdafayeu','duck;','dddd'),(30,'dsajdfonsdasdfkiafd@sdafayeu','duck;','dddd'),(31,'dsajdfonsdasdfkiafd@sdafayeu','duck;','dddd'),(32,'dsajdfonsdasdfkiafd@sdafayeu','duck;','dddd'),(33,'dsajdfonsdasdfkiafd@sdafayeu','duck;','dddd'),(34,'dsajdfonsdasdfkiafd@sdafayeu','duck;','dddd'),(35,'dsajdfonsdasdfkiafd@sdafayeu','duck;','dddd'),(36,'dsajdfonsdasdfkiafd@sdafayeu','duck;','dddd'),(37,'dsajdfonsdasdfkiafd@sdafayeu','duck;','dddd'),(38,'dsajdfonsdasdfkiafd@sdafayeu','duck;','dddd'),(39,'dsajdfonsdasdfkiafd@sdafayeu','duck;','dddd'),(40,'dsajdfonsdasdfkiafd@sdafayeu','duck;','dddd'),(41,'dsajdfonsdasdfkiafd@sdafayeu','duck;','dddd'),(42,'dsajdfonsdasdfkiafd@sdafayeu','duck;','dddd'),(43,'dsajdfonsdasdfkiafd@sdafayeu','duck;','dddd'),(44,'dsajdfonsdasdfkiafd@sdafayeu','duck;','dddd'),(45,'dsajdfonsdasdfkiafd@sdafayeu','duck;','dddd'),(46,'dsajdfonsdasdfkiafd@sdafayeu','duck;','dddd'),(47,'dsajdfonsdasdfkiafd@sdafayeu','duck;','dddd'),(48,'dsajdfonsdasdfkiafd@sdafayeu','duck;','dddd'),(49,'dsajdfonsdasdfkiafd@sdafayeu','duck;','dddd'),(50,'dsajdfonsdasdfkiafd@sdafayeu','duck;','dddd'),(51,'dsajdfonsdasdfkiafd@sdafayeu','duck;','dddd'),(52,'dsajdfonsdasdfkiafd@sdafayeu','duck;','dddd'),(53,'dsajdfonsdasdfkiafd@sdafayeu','duck;','dddd'),(54,'dsajdfonsdasdfkiafd@sdafayeu','duck;','dddd'),(55,'dsajdfonsdasdfkiafd@sdafayeu','duck;','dddd'),(56,'dsajdfonsdasdfkiafd@sdafayeu','duck;','dddd'),(57,'dsajdfonsdasdfkiafd@sdafayeu','duck;','dddd'),(58,'dsajdfonsdasdfkiafd@sdafayeu','duck;','dddd'),(59,'dsajdfonsdasdfkiafd@sdafayeu','duck;','dddd'),(60,'dsajdfonsdasdfkiafd@sdafayeu','duck;','dddd'),(61,'dsajdfonsdasdfkiafd@sdafayeu','duck;','dddd');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` char(68) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('john','{bcrypt}$2a$12$cvZO5dsU1OahL3w/KPpfY.nsziYMqIoXnQfbEOaP5Nr7NZLEsM2Se',1),('mary','{bcrypt}$2a$12$DTYdIwbTseVku8Y3BXxoPOU/yQPgOYZzHFuQOad/BoyX.zxNGqIl6',1),('susan','{bcrypt}$2a$12$6n451gDs/usQx1MrsfxjS.PxUGZqMlgqKscIO4OlqdRRU2R0wgzI.',1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-09-05  9:44:18
