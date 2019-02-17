<p># ny_times_app_updated-<br />Android(Java) application developed to hit the NY Time Most Popular articles API and display the list of articles along with the details when tapping on a single article.</p>
<p><br />The application is following the <strong>MVC</strong> pattern. since the <em>View</em>(which is the screen that the user interacts with) is presented as the layout folder which has the .xml files and interacts with the <em>Controller</em>(which is the one that gets the data from the Model &amp; passes it to the view). Also, the <em>Model</em> which interacts with the API to GET the list of articles from the NY Times API which afterwards will communicate with the Controller to update the layout for both when the list is loaded &amp; when the user tappes to view details of an article by useing the id of the clicked item.</p>
<p>Usage:&nbsp;</p>
<p>1st screen: Splash Screen&nbsp;</p>
<p>2nd screen: Login/registration, click on the dummy login button</p>
<p>3rd screen: List of most popular articles&nbsp;</p>
<p>4th screen : when tapping on an article the user will be taken to the details screen&nbsp;</p>
