export enum RequestStatus {
    PENDING,
    APPROVED,
    REJECTED
}

export interface Student {
    studentID: number;
    studentFullName: string;
    className: string;
    division: string;
    rollNo: string;
    email_id: string;
}

export interface Admin {
    email_id: string;
    admin_full_name: string;
}

export interface LeaveRequest {
    LeaveRequestId: number;
    studentID: number;
    student: Student;
    startDate: Date;
    endDate: Date;
    reason: string;
    status: RequestStatus;
    createdAt: Date;
    updatedAt: Date;
    approvedBy: Admin;
}

export interface ApprovalRequest {
    leaveRequestId: number;
    status: string;
    approvedBy: string;
}