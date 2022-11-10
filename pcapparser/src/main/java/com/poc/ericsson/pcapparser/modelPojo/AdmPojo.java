package com.poc.ericsson.pcapparser.modelPojo;

public class AdmPojo {
//	Request frame Number
	Long frame_number;
//	Request Port Number
	int req_port;
//	Request destination Port number
	int req_dest_port;
//	Request acknowledgment Number
	Long req_ackno_no;
//	Request Sequence Number
	Long req_seque_no;
//	Response acknowledgment Number
	Long res_ackno_no;
//	Response Sequence Number
	Long res_seq_no;
//	Request Arrival time
	Long req_arrival_time;
//	Response Arrival Time
	Long resp_arrival_time;
//	Calculted time between request and Response
	Long timesamp;

	public AdmPojo() {
		// TODO Auto-generated constructor stub
	}
// Constructor
	public AdmPojo(Long frame_number, int req_port, int req_dest_port, Long req_ackno_no, Long req_seque_no,
			Long res_ackno_no, Long res_seq_no, Long req_arrival_time, Long resp_arrival_time, Long timesamp) {
		super();
		this.frame_number = frame_number;
		this.req_port = req_port;
		this.req_dest_port = req_dest_port;
		this.req_ackno_no = req_ackno_no;
		this.req_seque_no = req_seque_no;
		this.res_ackno_no = res_ackno_no;
		this.res_seq_no = res_seq_no;
		this.req_arrival_time = req_arrival_time;
		this.resp_arrival_time = resp_arrival_time;
		this.timesamp = timesamp;
	}

	public Long getFrame_number() {
		return frame_number;
	}

	public void setFrame_number(Long frame_number) {
		this.frame_number = frame_number;
	}

	public int getReq_port() {
		return req_port;
	}

	public void setReq_port(int req_port) {
		this.req_port = req_port;
	}

	public int getReq_dest_port() {
		return req_dest_port;
	}

	public void setReq_dest_port(int req_dest_port) {
		this.req_dest_port = req_dest_port;
	}

	public Long getReq_ackno_no() {
		return req_ackno_no;
	}

	public void setReq_ackno_no(Long req_ackno_no) {
		this.req_ackno_no = req_ackno_no;
	}

	public Long getReq_seque_no() {
		return req_seque_no;
	}

	public void setReq_seque_no(Long req_seque_no) {
		this.req_seque_no = req_seque_no;
	}

	public Long getRes_ackno_no() {
		return res_ackno_no;
	}

	public void setRes_ackno_no(Long res_ackno_no) {
		this.res_ackno_no = res_ackno_no;
	}

	public Long getRes_seq_no() {
		return res_seq_no;
	}

	public void setRes_seq_no(Long res_seq_no) {
		this.res_seq_no = res_seq_no;
	}

	public Long getReq_arrival_time() {
		return req_arrival_time;
	}

	public void setReq_arrival_time(Long req_arrival_time) {
		this.req_arrival_time = req_arrival_time;
	}

	public Long getResp_arrival_time() {
		return resp_arrival_time;
	}

	public void setResp_arrival_time(Long resp_arrival_time) {
		this.resp_arrival_time = resp_arrival_time;
	}

	public Long getTimesamp() {
		return timesamp;
	}

	public void setTimesamp(Long timesamp) {
		this.timesamp = timesamp;
	}

//	ToString method
	@Override
	public String toString() {
		return "AdmPojo [frame_number=" + frame_number + ", req_port=" + req_port + ", req_dest_port=" + req_dest_port
				+ ", req_ackno_no=" + req_ackno_no + ", req_seque_no=" + req_seque_no + ", res_ackno_no=" + res_ackno_no
				+ ", res_seq_no=" + res_seq_no + ", req_arrival_time=" + req_arrival_time + ", resp_arrival_time="
				+ resp_arrival_time + ", timesamp=" + timesamp + "]";
	}

}
