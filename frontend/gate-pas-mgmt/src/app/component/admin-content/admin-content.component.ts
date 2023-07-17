import { Component,OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { LeaveRequest, RequestStatus } from 'src/app/data-models';
import { DataService } from 'src/app/service/data.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-admin-content',
  templateUrl: './admin-content.component.html',
  styleUrls: ['./admin-content.component.scss']
})
export class AdminContentComponent implements OnInit {
  adminname:any;
  lookupForm: FormGroup;
  studentReqClicked=false;
  pendingReqClicked=false;
  studentIdEntered=false;

  constructor(private formBuilder: FormBuilder,private dataservice:DataService,private route: ActivatedRoute) {
    this.lookupForm = this.formBuilder.group({
      studentId: ['', Validators.required]
    });
  }

  studentRequests!:LeaveRequest[];
  requests!:LeaveRequest[];

  // requests = [
  //   { id: 1, studentName: 'John Doe', class: '10A', status: 'Pending' },
  //   { id: 2, studentName: 'Jane Smith', class: '9B', status: 'Approved' },
  //   // Add more requests
  // ];
  
  TogglependingReqClicked()
  {
    if(this.pendingReqClicked==false)
    {
      this.dataservice.getAllPendingRequests().subscribe(
        resp=>{
          this.requests=resp;
          this.pendingReqClicked=!this.pendingReqClicked;
        }
      );
    }
    else
    {
      this.pendingReqClicked=!this.pendingReqClicked;

    }
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
    this.dataservice.postAdminApproval(requestId,'approved',this.adminname).subscribe(
      resp=>{
        console.log(resp);
        console.log('succesfully approved');
      }
    );
    this.dataservice.getAllPendingRequests().subscribe(
      resp=>{
        this.requests=resp;
      }
    );
    // this.requests = [
    //   { id: 1, studentName: 'ascsac Doe', class: '10A', status: 'Pending' },
    //   { id: 2, studentName: 'acac Smith', class: '9B', status: 'Approved' },
    //   // Add mgore requests
    // ];
    console.log(`Approved request with ID: ${requestId}`);
  }
  // postAdminApproval(leaveRequestId: number, status: string, approvedBy: string) {

  rejectRequest(requestId: number) {
    // Handle reject logic
        //make a request to send the reject signal
        
         //calculate the requestListAgain

        //send a message to student-content to recalculate the request list
        this.dataservice.postAdminApproval(2, 'REJECTED' ,this.adminname).subscribe(
          resp=>{
            console.log(resp);
            console.log('succesfully rejected');
          }
        );
        this.dataservice.getAllPendingRequests().subscribe(
          resp=>{
            this.requests=resp;
          }
        );
        //this.requests=get from the service

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

    this.dataservice.getAllRequestsByStudentId(studentId).subscribe(
      res=>{
        this.studentRequests=res;
        console.log(res);
      }
     );

    // You can make API calls or perform other operations to retrieve the student's requests based on the ID
  }
  onClearstudentReq()
  {
    this.studentReqClicked=false;
  }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      const name = params['adminName'];
      this.adminname=name;
      console.log(name);
      // Use the data in Component2

    });
  }
}
