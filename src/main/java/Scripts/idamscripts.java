package Scripts;

import java.util.Map;

import org.testng.annotations.Test;

import Generic_Libraries.basicmethods;
import pagefactory.pf_activedirectory;
import pagefactory.pf_backup;
import pagefactory.pf_changepassword;
import pagefactory.pf_createAdmin;
import pagefactory.pf_dashboard;
import pagefactory.pf_departments;
import pagefactory.pf_ldap;
import pagefactory.pf_logout;
import pagefactory.pf_profile;
import pagefactory.pf_reports;
import pagefactory.pf_superadminlogin;

public class idamscripts extends basicmethods{
	
	@Test(dataProvider = "Valid",dataProviderClass=Dataproviders.dp_login.class,enabled = true, groups= {"SMK"})
	public void login(Map hm) throws Exception {
		
	String uid = hm.get("Uname").toString();
	String pas = hm.get("Pwd").toString();
	String fn = hm.get("Firstname").toString();
	String mn = hm.get("Middlename").toString();
	String ln = hm.get("Lastname").toString();
	String gn = hm.get("Gender").toString();
	String dob = hm.get("DOB").toString();
	String mo = hm.get("Mobilenumber").toString();
	String em = hm.get("Email").toString();
	String un = hm.get("Username").toString();
	String or = hm.get("Organization").toString();
	String de = hm.get("Department").toString();
	String ep = hm.get("EmpID").toString();
	String rl = hm.get("Role").toString();
	String a1 = hm.get("Address1").toString();
	String a2 = hm.get("Address2").toString();
	String co = hm.get("Country").toString();
	String st = hm.get("State").toString();
	String dt = hm.get("District").toString();
	String zi = hm.get("Zipcode").toString();
	String ud = hm.get("User to delete").toString();
	String ed = hm.get("Edituser").toString();
	String in = hm.get("Inactivateuser").toString();
	String dep = hm.get("Deptname").toString();
	String editinput = hm.get("Editdeptname").toString();
	String cp = hm.get("Currentpass").toString();
	String np = hm.get("Newpass").toString();
	String con = hm.get("Confirmpass").toString();
	String cna = hm.get("Connectionname").toString();
	String ur = hm.get("LDAPurl").toString();
	String ct = hm.get("LDAPcontainer").toString();
	String ad = hm.get("LDAPusername").toString();
	String ap = hm.get("LDAPpass").toString();
	
	pf_superadminlogin ps = new pf_superadminlogin(s);
	ps.sal(uid, pas);
	pf_dashboard pd = new pf_dashboard(s);
	pd.dashboard();
	pf_createAdmin pc = new pf_createAdmin(s);
	pc.create(fn,mn,ln,gn,dob,mo,em,un,or,de,ep,rl,a1,a2,co,st,dt,zi);
	pc.manageadmin(ud,ed,in, s);
	pf_departments pde = new pf_departments(s);
	pde.createdepartment(dep);
	pde.managedepartment(s,editinput);
	pf_backup pb = new pf_backup(s);
	pb.backup();
	pf_reports pr = new pf_reports(s);
	pr.report(s);
	pf_profile pp = new pf_profile(s);
	pp.profilepage(s);
	pf_changepassword pcp = new pf_changepassword(s);
	pcp.changepassword(cp, np, con);
	pf_activedirectory pa = new pf_activedirectory(s);
	pa.activedirectorysettings();
	pf_ldap pld = new pf_ldap(s);
	pld.ldap(cna, ur, ct, ad, ap);
	pld.manageldap();
	pf_logout pl = new pf_logout(s);
	pl.logout();
	}
}
