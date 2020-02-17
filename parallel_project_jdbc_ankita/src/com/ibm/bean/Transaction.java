	package com.ibm.bean;

	import java.sql.Timestamp;

	public class Transaction {
		Integer from_acc;
		Integer to_acc;
		String tran_type;
		Timestamp dtime;
		Integer amt;
		public Integer getFrom_acc() {
			return from_acc;
		}
		public void setFrom_acc(Integer from_acc) {
			this.from_acc = from_acc;
		}
		public Integer getTo_acc() {
			return to_acc;
		}
		public void setTo_acc(Integer to_acc) {
			this.to_acc = to_acc;
		}
		public String getTran_type() {
			return tran_type;
		}
		public void setTran_type(String tran_type) {
			this.tran_type = tran_type;
		}
		public Timestamp getDtime() {
			return dtime;
		}
		public void setDtime(Timestamp dtime) {
			this.dtime = dtime;
		}
		public Integer getAmt() {
			return amt;
		}
		public void setAmt(Integer amt) {
			this.amt = amt;
		}
		public String toString() {
			return "Transaction [from_account_no=" + from_acc + ", to_account_no=" + to_acc+", Transaction_type=" + tran_type +", Amount=" + amt+ ", Transaction_date_time=" + dtime+ "]";
			//balance status ? 
		}

		
		
	}
