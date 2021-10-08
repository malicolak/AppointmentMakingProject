# AppointmentMakingProject
This project is a small-scale appointment system.

First, I called the classes that are required for the assignment and which are in the java library.

Then I created a class named person. This class has one parameterless constructor and one parameter-taking constructor.

The variables in the person class are name, surname, email, phone, respectively. I assigned the parameters in the parameter-taking method to the variables inside the person class with this command.

Then I created a class named student. I used inheritance when creating this class.So I created this class as a subclass of the person class. I achieved this with the extend command. The variables of the student class are the number register and the section. Likewise, this class has two constructor methods. the first one is without parameters. The second is parameterized.Before assigning the parameters that come with the parameter constructor to the variables in the student class, I assigned the no record and the part in the parameter that came with the super command, which is a feature of inheritance, to the variables in the person. i.e. I called the constructor method of the Person class that takes parameters.

I created a method named "randevual" inside the student class. This method is responsible for taking the parameters sent from the main method and writing them to the "randevular.txt" file. At first I created a bufferedwriter with a try block and got my appointments file ready to write. then I wrote it to the parameterized file sent respectively. I've added a catch block here for possible error checking.

Then I created a method named list appointments in the student class.This method is used to list the appointments in the appointments file as output to the screen. At first I created a bufferedreader controlled with a try block. Then I created a reference variable in my hand by assigning the first line of the appointments file to my variable named suankisatir. Then I set up a while loop and started reading my appointments file line by line. I wrote to the screen with the sout command in every line I read. I created a catch block for possible file errors after the try block. After the error occurred, I terminated the program in a controlled manner with the System.exit command.

Then I created a toString method inside the student class that returns a String. This method returns the information of the student sent from the main method as a string.

Then I created a new class named academician. I created this class again by using inheritance. so I created it as a subclass of the person class. I created the variables of this class as sicilno department and title. Again, this class has two constructor methods. the first one is empty and the second one is parameterized. The reason I created an empty constructor was so that I could call the class directly without sending any parameters through the main method. I created a parameterless constructor method so that I can perform operations through the main method. As I did in the student class, I assigned the parameters that come with the parameterized constructor method to the in-class variables. I made use of this command. Again, as I did in the student class, I called the constructor method of the person class with the super command. I made assignments to the in-class variables.

Then I created a method called my appointments inside the academics class. This method takes the registration number of the academician that comes to it as a parameter and lists the appointments of that academician. When creating this method, I first create a bufferedreader in the try control. Then I start reading the first line of the appointments file with the control variable. Then I created a boolean type variable here. Thanks to this, if the number of the academician is not in the appointments file, I return false value and terminate the program in a controlled way. Again, I read the whole file with the while loop. I also control it with the catch block and terminate the program in a controlled manner.

Then I created a toString method inside the academic class that returns String. This method returns the information of the registered academic as a string.

Then I created a class called odev1.

Then I created a list method inside the odev1 class. This method takes an int value as a parameter. If the number as a parameter is equal to one, it lists the records in the student file. if it is equal to two, it lists the records in the academic file. I made the necessary check if the numbers are entered as 1 or 2 external.

Then I created a method called ogroku inside the odev1 class that sends a String array. I created a String array of bin indices size. Then I created a try-controlled buffered reader that reads the student file. Then I started to read the file with the while loop. In the for loop, I divided each line I read into a space with split and threw it into the word string and soutla the i of the word string. I wrote the index on the screen. I took the necessary precautions with catch and returned the word array.

I placed my main method inside the odev1 class.

As a start, I informed and directed the user with the sout commands.

Adding students when 1 is pressed

Adding academics when 2 is pressed

Making an appointment by pressing 3

When 4 is pressed, appointment listing process

When 5 is pressed, the process of listing students or academics

Returning student information as an array when 6 is pressed

The process of sorting the appointments of the academician whose registration number is entered when 7 is pressed.

I made it.


By creating a scanner object, I provided data entry to the system.

I put it all in a large try block.

Then, I provided the number input to the variable I defined as requestno, in accordance with the directions from the keyboard. I closed the error caused by entering wrong data with a catch block.

here I used an if block. if the request is equal to one, I started the student enrollment process.

I created a BufferedWriter with a try control. Then I took the necessary information for the student from the keyboard, respectively. While getting the student number, I also checked if there is a student already registered with this number. I did this by reading the file with a try-controlled Buffered reader. For possible file shortages, I placed a catch block. After getting the information, I created an object from the student class and sent the values ​​I entered as a parameter.

here, I created a stage to return the student's information as a string, depending on the user's request.

I created an object of the scanner class with the request name.

I created a variable with the name requestnumber in String type and assigned the value entered from the keyboard.

I checked with the if block.

If the request number is equal to one as a String, I call the tostring method in the student class with the sout command and write it to the screen. I provided the string equality with the equalsignorecase command.

then I completed the if block by writing the data to the file and ended my program.

I placed a catch block for possible problems.

Then, with the else if command, I created the situation where the request is equal to 2.

I created this place to register an academician.

Again, I applied the same procedures of creating a student here.

Unlike here, I just checked the sicilno.

Likewise, I created a method to freeze the optionally saved academician's information as a string.

If the person chooses 1, the information will be returned as a string and printed on the screen.

then the entered information will be written to the academic file and the program will end.

I did not neglect to use catch block for possible problems.

If the person chooses 3, the appointment process starts.

Again, I created a try-controlled BufferedWriter here. Then I created an object named o1 from the student class. Then I started to get the information from the keyboard, respectively.

While getting the student number, I checked whether such a student exists. If there is such a student, I continued, otherwise I terminated the program.

Then I applied the same process when I got the academician's registration number.

Then I got the appointment date. I got the appointment date. I got the date of the appointment as year month day respectively and made the year be 2020 and above, the month between 1 and 12 and the day between 1 and 31.

Then I got the appointment start time and end time. Afterwards, I inquired about the appointments file and questioned whether the academician to whom the registry belonged had another appointment on the entered date, thanks to the entered sicil number. otherwise, I printed it to the appointments file thanks to the appointment method. I did not neglect to use catch block for possible errors.

If the person chooses 4, I started the process of listing the appointments.

I created an object named o1 from the student class and listed the appointments by calling the list appointment method.

If the person chooses 5, I started the process of listing the student file or the academic file. I created a variable named decision here. If the person chooses one, the process of listing the students begins.

If the academician chooses two, the listing process starts. In case of an incorrect entry, I provided the necessary precautions with catch blocks.

If the person chooses 6, the process of returning the student information as a string starts.

I created a Strig array called ogrdizi and assigned the array that came with the ogroku method to the ogrdiz.

If the person chooses 7, I started the process of sorting the appointments of the academic whose registration number is entered.

I created an int variable with the name no. I also created an object from the academic class named a.

Thanks to the class object I created, I accessed my appointments method and sent my no variable as a parameter.

If the person enters a number or character other than these numbers, I took the necessary precautions.

And I completed the program.

First of all, the program asks us for the number of the operation we want to do.

Your Choice!
