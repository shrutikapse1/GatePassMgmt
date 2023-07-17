import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-admin-content',
  templateUrl: './admin-content.component.html',
  styleUrls: ['./admin-content.component.scss']
})
export class AdminContentComponent {
  lookupForm: FormGroup;
  studentReqClicked=false;
  pendingReqClicked=false;
  studentIdEntered=false;

  constructor(private formBuilder: FormBuilder) {
    this.lookupForm = this.formBuilder.group({
      studentId: ['', Validators.required]
    });
  }

  studentRequests = [
    { id: 1, name: 'John Doe', class: '10A', status: 'Pending' },
    { id: 2, name: 'Jane Smith', class: '9B', status: 'Approved' },
    // Add more student requests
  ];
  requests = [
    { id: 1, studentName: 'John Doe', class: '10A', status: 'Pending' },
    { id: 2, studentName: 'Jane Smith', class: '9B', status: 'Approved' },
    // Add more requests
  ];
  
  TogglependingReqClicked()
  {
    this.pendingReqClicked=!this.pendingReqClicked;
  }

  TogglestudentReqClicked()
  {
    this.studentReqClicked=!this.studentReqClicked;
  }
  TogglestudentIdEntered()
  {
     this.studentIdEntered=!this.studentIdEntered;
  }


  approveRequest(requestId: number) {
    // Handle approve logic
    //make a request to send the approve signal

    //calculate the requestListAgain

    //send a message to student-content to recalculate the request list
    // let lastElement = this.requests.pop();
    this.requests = [
      { id: 1, studentName: 'ascsac Doe', class: '10A', status: 'Pending' },
      { id: 2, studentName: 'acac Smith', class: '9B', status: 'Approved' },
      // Add more requests
    ];
    console.log(`Approved request with ID: ${requestId}`);
  }

  rejectRequest(requestId: number) {
    // Handle reject logic
        //make a request to send the reject signal
        
         //calculate the requestListAgain

        //send a message to student-content to recalculate the request list


    console.log(`Rejected request with ID: ${requestId}`);
  }

  onSubmit() {
    if (this.lookupForm.invalid) {
      return;
    }
    this.studentIdEntered=true;
    const studentId = this.lookupForm.value.studentId;
    
    // Perform lookup logic based on the student ID
    console.log('Lookup Student ID:', studentId);
    // You can make API calls or perform other operations to retrieve the student's requests based on the ID
  }
  onClearstudentReq()
  {
    this.studentReqClicked=false;
  }
}
