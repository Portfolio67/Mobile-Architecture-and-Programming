# Mobile-Architecture-and-Programming


<html>
<head>
	<meta charset="UTF-8">

</head>
<body>
<h1 id="readme-android-app-development"><strong>README:</strong> Android App Development by Shane Flaten</h1>

<p>Shane Flaten</p><div class="TOC">

<a href="https://xd.adobe.com/view/c027b130-89e6-4091-af05-179d0a8e41f6-9574/">Visit The Adobe XD mock-Up of the App </a>	

<ul>
<li><a href="#readme-android-app-development"><strong>README:</strong> Android App Development</a></li>
<li><a href="#the-goals-of-the-project"><strong>The goals of the project</strong></a></li>
<li><a href="#coding-process"><strong>Coding Process.</strong></a></li>
<li><a href="#ui-screens-and-features-controller-and-view"><strong>Ui</strong> **screens and features <strong>“Controller and View”</strong></a></li>
<li><a href="#functional-app-requirements-connected-to-the-ui-model-and-controller"><strong>Functional app requirements connected to the UI</strong> <strong>“Model and Controller”</strong></a></li>
<li><a href="#code-examples"><strong>Code Examples.</strong></a></li>
<li><a href="#testing"><strong>Testing</strong></a></li>
</ul>
</div>

<h1 id="the-goals-of-the-project"><strong>The goals of the project</strong></h1>

<p>I have chosen to work on a simple inventory app. The main purpose of this app is for a business to be able to track and manage their inventory. The App will need the following:</p>

<p>This project was mainly on Interface and architectural design. For that reason, I made a mockup in adobe XD first. The mockup did not match the exact requirements, as the requirements in this project were more minimal in the mock up. The code in the project is not the code I would use to publish a final app. It’s minimal on security and modern functionality.</p>

<pre><code>- Login Page and Authentication / user account creation.    If you choose to create a new account, it’ll pop up to a new page with text boxes that are input for the SQLite data base. This data will populate a separate database than the Products.
- A main Landing Page after login will show a grid of items. Three navigation buttons on the bottom footer, refresh, SMS, add. For the header will have an App Name. Each line in the great will have an edit button and a delete button.
- The manage items page will be a grid and will have a floating plus button to add. Once added there will be a delete icon or a plus minus to add or remove items.The float button that’s a circle plus is a new feature in android and brings up a box that floats over the current page until something is added. There will be a refresh button and a navigation button to the SMS notification page.
- There must be standards in icon usage otherwise it would be difficult to understand what icons produce certain results. Another standard would be the navigation where you can go forward and backwards is always on the top.
- The app should use a version that supports at least 90% of active devices. 
- SMS authorization page requires do user to allow use of SMS for notifications. That must be able to make texts, and automated text service for low inventory.
- The must also utilize standard android best codeine practices and user interface design.
</code></pre>

<h1 id="coding-process"><strong>Coding Process.</strong></h1>

<p>The technique I used was the agile process of creating a user story out of the requirements. First a mockup was made out of the user requirements in Adobe XD, then a layout was designed an android studio. The functionality translated into requirements, which then took the place of widgets and functional components in the code. Each component I worked on separately and researched independently, then design and implement normal coding practices in android studio. There were two databases here, communicate between classes with intents. I made two separate apps in many different versions of the app and each incrementing a new component each time. This process could be used in the future with any team breaking off into smaller groups and working on certain functionality features. Testing was done during the process of the build. This is necessary for any app call back in place. The android emulator is a great tool in conjunction with the log cat. I also made use of log which can be imported to each class. This log will print a text value to tell you where you are in the code while it’s being executed. You can use valueOf() inside the log tag to get a print out of the values. This ensures the code is functional without having to put in breakpoints. If the app does not run in the emulator the log and the logcat will show what is going on. Requirements requested they use a grid layout. This was difficult to use in conjunction with SQliteobjects. I had to switch to a table view and would prefer a list view with a scroll in the future. You can use the grid with a scroll but accessing an entire object becomes difficult. For thisreason I made a list out of the object in the SQlightcolumns. In the future I will use moreSQlight manipulation as opposed to attempting to do it in the controller. I made use of a dialog pop-up screen to create a new object inside the database. This is a useful tool and is standard an android. The use of fragments is difficult to code in the long run. For this project simple button navigation worked.</p>

<h1 id="ui-screens-and-features-controller-and-view"><strong>Ui</strong> **screens and features <strong>“Controller and View”</strong></h1>

<p>The navigation will be on the bottom reachable by the thumbs. This will be the footer of the app which has evenly placed buttons that are large enough to meet the android guidelines in the android helper. The app would be very predictable with easy to see navigation with common icons and simple typography. It would be no surprises with the change of states of each component. There will also be a garbage can icon to the right in case something needs to be deleted. They will be a floating circle with a + at the bottom right so that the warehouse worker can easily click it with their thumb and begin the process of populating a form that pops up. </p>
<img width="402" alt="Screen Shot 2021-12-19 at 9 56 43 PM" src="https://user-images.githubusercontent.com/75280131/146925467-81435e48-6010-47e2-99ec-a7b993e46f9e.png">
<img width="428" alt="Screen Shot 2021-12-19 at 9 42 14 PM" src="https://user-images.githubusercontent.com/75280131/146925496-be08d29b-bc5d-4c47-90d4-55ccc1c8a7e5.png"><img width="360" alt="Screen Shot 2021-12-17 at 8 10 33 AM" src="https://user-images.githubusercontent.com/75280131/146925549-ae7bb177-548f-4c20-bcb4-1bebd7f9f4a6.png">

<img width="359" alt="Screen Shot 2021-12-17 at 8 10 16 AM" src="https://user-images.githubusercontent.com/75280131/146925567-e0d76cca-1ba0-4e37-8244-e4efd9a4644b.png">

<p>Everything used basic material user interface items. Icons will be recognizable, and the colors will not be confusing to the User. For every action there should be a way to undo an action or in this case a toast icon pops up. </p>

<p>Here are standard heights for layout that’s easy to use.</p>

<p>Status bar height: 24dp2. App bar height: 56dp
3. List item height: 88dp</p>

<h1 id="functional-app-requirements-connected-to-the-ui-model-and-controller"><strong>Functional app requirements connected to the UI</strong> <strong>“Model and Controller”</strong></h1>

<p>The function of the app begins at the login. When a user creates create account by registering this populates a database.This whole App will use the model view control including with the login. The app should save the state in case of switching to another app or changing to portrait mode, but not utilized in this project. The log is the password text widget to hide that uses input.</p>

<p>Android has libraries and functions to ensure that if an email has been entered that it has the correct format, this project strings were used. </p>
	
	<img width="467" alt="Screen Shot 2021-12-21 at 5 57 22 AM" src="https://user-images.githubusercontent.com/75280131/146928951-1852be26-c9ba-43c9-9d42-7f55b5a00b63.png">
<img width="522" alt="Screen Shot 2021-12-21 at 5 58 21 AM" src="https://user-images.githubusercontent.com/75280131/146928972-fc33b635-955e-43e3-9ee9-ad112b931371.png">
<img width="522" alt="Screen Shot 2021-12-21 at 6 00 48 AM" src="https://user-images.githubusercontent.com/75280131/146928999-76311b2d-8a68-4a6a-8421-a08f55aa5462.png">

<img width="522" alt="Screen Shot 2021-12-21 at 5 58 33 AM" src="https://user-images.githubusercontent.com/75280131/146928983-fb2f19e4-29e0-43a7-8c82-5bd7f17e4962.png">
<img width="406" alt="Screen Shot 2021-12-21 at 6 28 46 AM" src="https://user-images.githubusercontent.com/75280131/146930364-93559a20-57ff-401f-a7e8-535f09c03d29.png">
<img width="398" alt="Screen Shot 2021-12-21 at 6 28 53 AM" src="https://user-images.githubusercontent.com/75280131/146930371-1a14c33a-e08f-4076-a2c8-2183f8dc09cd.png">
<img width="412" alt="Screen Shot 2021-12-21 at 6 29 02 AM" src="https://user-images.githubusercontent.com/75280131/146930388-2b4d2540-22d2-4780-a08b-2e74f96c1c85.png">

<h1 id="code-examples"><strong>Code Examples.</strong></h1>
	<img width="1247" alt="Screen Shot 2021-12-21 at 6 04 40 AM" src="https://user-images.githubusercontent.com/75280131/146929042-573b27ed-fae5-44a6-b267-f94c8769b6ff.png">
<img width="1221" alt="Screen Shot 2021-12-21 at 6 09 50 AM" src="https://user-images.githubusercontent.com/75280131/146929099-5d6084d4-0cdd-4e18-b3ae-e3d177898901.png">

<img width="973" alt="Screen Shot 2021-12-19 at 9 12 38 PM" src="https://user-images.githubusercontent.com/75280131/146926027-9103befa-6edf-448f-a670-646f5a569e93.png">
<img width="1201" alt="Screen Shot 2021-12-21 at 6 09 33 AM" src="https://user-images.githubusercontent.com/75280131/146929114-80024dbc-65a7-49bf-a590-b116187c3fad.png">
<img width="899" alt="Screen Shot 2021-12-21 at 6 08 55 AM" src="https://user-images.githubusercontent.com/75280131/146929124-61a012e0-ab3e-4a0b-a39d-09998346b7d6.png">
<img width="1461" alt="Screen Shot 2021-12-21 at 6 08 00 AM" src="https://user-images.githubusercontent.com/75280131/146929177-e5aae995-40b0-45de-867b-753a87031def.png">
<img width="1185" alt="Screen Shot 2021-12-21 at 6 08 29 AM" src="https://user-images.githubusercontent.com/75280131/146929192-4d14c110-c81c-496d-b1ec-569db4c5f1cf.png">
<img width="1027" alt="Screen Shot 2021-12-21 at 6 07 02 AM" src="https://user-images.githubusercontent.com/75280131/146929214-e3130064-3e42-4c8c-8923-0c50106d10a8.png">
<img width="987" alt="Screen Shot 2021-12-21 at 6 06 16 AM" src="https://user-images.githubusercontent.com/75280131/146929230-beaa02c2-6d60-460d-b842-9d25c1f49af4.png">
<img width="912" alt="Screen Shot 2021-12-21 at 6 06 07 AM" src="https://user-images.githubusercontent.com/75280131/146929235-33b37708-c81e-4c07-8e8c-35f87c2d77cc.png">
<img width="897" alt="Screen Shot 2021-12-21 at 6 05 51 AM" src="https://user-images.githubusercontent.com/75280131/146929251-48caa085-5714-4bb6-aa57-6a8208dca257.png">
<img width="1099" alt="Screen Shot 2021-12-21 at 6 05 31 AM" src="https://user-images.githubusercontent.com/75280131/146929262-ff528178-6d67-494d-b3b0-1c0a8160c67a.png">
<img width="762" alt="Screen Shot 2021-12-21 at 6 29 24 AM" src="https://user-images.githubusercontent.com/75280131/146930207-5a245765-e712-4b01-9807-de71f19707a1.png">

<h1 id="testing"><strong>Testing</strong></h1>
<img width="1006" alt="Screen Shot 2021-12-21 at 6 23 41 AM" src="https://user-images.githubusercontent.com/75280131/146930255-2af3e44e-9e37-414f-af11-4fd97c769637.png">
<img width="706" alt="Screen Shot 2021-12-21 at 6 25 32 AM" src="https://user-images.githubusercontent.com/75280131/146930263-57f77f5d-076b-4b7e-bc00-bfa2a02dec4b.png">
<img width="1391" alt="Screen Shot 2021-12-21 at 6 26 36 AM" src="https://user-images.githubusercontent.com/75280131/146930275-65ead5a3-220c-452b-b6f7-f9ce3d916f53.png">

<img width="1367" alt="Screen Shot 2021-12-21 at 6 28 31 AM" src="https://user-images.githubusercontent.com/75280131/146930640-f718f79a-bdb9-46d1-8974-f0d1d1e52352.png">

<p>Testing can be done with the De-bugger, logs and running in the simulator</p>
</body>
</html>


