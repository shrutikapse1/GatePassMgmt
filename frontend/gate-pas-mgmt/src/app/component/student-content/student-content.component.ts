import { Component,OnInit  } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
@Component({
  selector: 'app-student-content',
  templateUrl: './student-content.component.html',
  styleUrls: ['./student-content.component.scss']
})
export class StudentContentComponent {
  myForm!: FormGroup;
  isShowALLreqClicked=false;
  makeNewReqClicked=false;
  studentRequests = [
    { id: 1, name: 'John Doe', class: '10A', status: 'Pending' },
    { id: 2, name: 'Jane Smith', class: '9B', status: 'Approved' },
    // Add more student requests
  ];
  constructor(private formBuilder: FormBuilder) { 

    this.myForm = this.formBuilder.group({
      fullName: ['', Validators.required],
      studentId: ['', Validators.required],
      class: ['', Validators.required],
      division: ['', Validators.required],
      rollNumber: ['', Validators.required],
      leaveStartDate: ['', Validators.required],
      leaveEndDate: ['', Validators.required],
      reason: ['', Validators.required],
    });
  }

  ToggleisShowALLreqClicked()
  {
    this.isShowALLreqClicked=!this.isShowALLreqClicked;
  }
  ToggleonmakeNewReqClicked()
  {
    this.makeNewReqClicked=!this.makeNewReqClicked;
  }
  getStudentRequests()
  {
    //making a get call with parameter as student ID
  
  }



  onSubmit() {
    if (this.myForm.invalid) {
      return;
    }

    // Form submission logic

    //Make A post Request 

    //send a message to admin-content to recalculate the requests list
    console.log('successfull submisiion');
    console.log(this.myForm.value);

    const formData = this.myForm.value;

    // this.http.post('your-backend-api-url', formData)
    //   .subscribe(
    //     response => {
    //       // Handle success response
    //       console.log(response);
    //       getStudentRequests();
    //     },
    //     error => {
    //       // Handle error response
    //       console.error(error);
    //     }
    //   ); 
  }
 

  
 
}
