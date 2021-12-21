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

<h1 id="code-examples"><strong>Code Examples.</strong></h1>

<h1 id="testing"><strong>Testing</strong></h1>

<p>Testing can be done with the De-bugger, logs and running in the simulator</p>
</body>
</html>


