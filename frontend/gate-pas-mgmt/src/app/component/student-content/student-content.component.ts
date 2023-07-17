import { Component,OnInit  } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { DataService } from 'src/app/service/data.service';
import { ActivatedRoute } from '@angular/router';
import { LeaveRequest } from 'src/app/data-models';
@Component({
  selector: 'app-student-content',
  templateUrl: './student-content.component.html',
  styleUrls: ['./student-content.component.scss']
})
export class StudentContentComponent implements OnInit {
  myForm!: FormGroup;
  studentId:any;
  isShowALLreqClicked=false;
  makeNewReqClicked=false;
  studentRequests!:LeaveRequest[];
  constructor(private formBuilder: FormBuilder,private dataservice:DataService,private route: ActivatedRoute ) { 

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
    this.getStudentRequests();
  }
  ToggleonmakeNewReqClicked()
  {
    this.makeNewReqClicked=!this.makeNewReqClicked;
  }
  getStudentRequests()
  {
     this.dataservice.getAllRequestsByStudentId(this.studentId).subscribe(
      res=>{
        this.studentRequests=res;
        console.log(res);
      }
     );
  }

  // postSubmitRequestForm(studentId: number, startDate: Date, endDate: Date, reason: string) {


  onSubmit() {
    if (this.myForm.invalid) {
      return;
    }

    // Form submission logic

    //Make A post Request 

    //send a message to admin-content to recalculate the requests list
    console.log('successfull submisiion');
    console.log(this.myForm.value.leaveStartDate);

    const formData = this.myForm.value;
    this.dataservice.postSubmitRequestForm(formData.studentId,formData.leaveStartDate,formData.leaveEndDate,formData.reason);
    alert('successful submission, you would now be redirected back to home page');
    this.ToggleonmakeNewReqClicked();

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
  ngOnInit()
  {
    this.route.params.subscribe(params => {
      const sid = params['sid'];
      this.studentId=sid;
      console.log(sid);
      // Use the data in Component2

    });

    

  }
 

  
 
}
