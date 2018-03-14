package JobPortal;

/**
 *
 * @author 804653
 * @version 0.0.1
 */
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


public class SearchGUI extends javax.swing.JFrame {

    protected String host = "jdbc:derby://localhost:1527/Job_Portal;create=true;user=Job_Portal;password=Job_Portal";
    private String searchSql = "Select * from JOBS where";
    private String keyword = "''";

    protected static Connection con;
    private ResultSet rs;
    protected static Statement stmt;

    /**
     * Creates new form NewJFrame
     */
    public SearchGUI() {
        initComponents();
        /* setting an attribute in a Properties object */

        try {
            con = DriverManager.getConnection(host);
            
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
        dropJobsTable();
        createJobsTable();
        populateJobsTable();
    }

public static void dropJobsTable(){ 
    String dropTableJobs = ("Drop Table Jobs");

        try {
            stmt = con.createStatement();
            SearchGUI.stmt.execute(dropTableJobs);
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                System.out.println("Could not close query");
            }

        }
    } ;

    public static void createJobsTable() {

        String creatTableJobs = ("CREATE TABLE JOBS (JOB_ID int not null, "
                + "JOB_TITLE varchar(100),"
                + "JOB_TYPE varchar (250),"
                + "ADDRESS varchar (250),"
                + "COUNTRY varchar (250),"
                + "JOB_DESCRIPTION varchar(2500),"
                + "SECTOR varchar(60), "
                + "COMPANY_NAME varchar(150),"
                + "SALARY varchar (100),"
                + "APPLY_BY_DATE date,"
                + "PRIMARY KEY (Job_ID) )");

        try {
            stmt = con.createStatement();
            SearchGUI.stmt.execute(creatTableJobs);
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                System.out.println("Could not close query");
            }

        }
    } ;
    public static void populateJobsTable() {

        String populate1 = ("insert into JOBS (JOB_ID, JOB_TITLE, JOB_TYPE, JOB_DESCRIPTION, SECTOR, COMPANY_NAME, SALARY, ADDRESS, COUNTRY, APPLY_BY_DATE) values (1, 'Professor', 'Internship', 'orci luctus et ultrices posuere cubilia curae donec pharetra magna vestibulum aliquet ultrices erat tortor sollicitudin mi sit amet lobortis sapien sapien non mi integer ac neque duis bibendum morbi non quam nec dui luctus rutrum nulla tellus in sagittis dui vel nisl duis ac nibh fusce lacus purus aliquet at feugiat non pretium quis lectus suspendisse potenti in eleifend quam a odio in hac habitasse platea dictumst maecenas ut massa quis augue luctus tincidunt nulla mollis molestie lorem quisque ut erat curabitur gravida nisi at nibh in hac habitasse platea dictumst aliquam augue quam sollicitudin vitae consectetuer eget rutrum', 'Consumer Services', 'Shufflebeat', '$37823.73', '22 Utah Terrace', 'China', '10/31/2018')\n" +
",(2, 'Operator', 'Temporary', 'ultrices posuere cubilia curae mauris viverra diam vitae quam suspendisse potenti nullam porttitor lacus at turpis donec posuere metus vitae ipsum aliquam non mauris morbi non lectus aliquam sit amet diam in magna bibendum imperdiet nullam orci pede venenatis non sodales sed tincidunt eu felis fusce posuere felis sed lacus morbi sem mauris laoreet ut rhoncus aliquet pulvinar sed nisl nunc rhoncus dui vel sem sed sagittis nam congue risus semper porta volutpat quam pede lobortis ligula sit amet eleifend pede libero quis orci nullam molestie nibh in lectus pellentesque at nulla suspendisse potenti cras in purus eu magna vulputate luctus cum sociis natoque penatibus', 'Transportation', 'Devshare', '£79625.69', '81 Kinsman Alley', 'Indonesia', '6/22/2018')\n" +
",(3, 'Senior Cost Accountant', 'Temporary', 'vulputate ut ultrices vel augue vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae donec pharetra magna vestibulum aliquet ultrices erat tortor sollicitudin mi sit amet lobortis sapien sapien non mi integer ac neque duis bibendum morbi non quam nec dui luctus rutrum nulla tellus in sagittis dui vel nisl duis ac nibh fusce', 'Construction', 'Ozu', '¥22968.46', '831 Hoffman Street', 'Germany', '12/26/2018')\n" +
",(4, 'Health Coach I', 'Part_Time', 'id justo sit amet sapien dignissim vestibulum vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae nulla dapibus dolor vel est donec odio justo sollicitudin ut suscipit a feugiat et eros vestibulum ac est lacinia nisi venenatis tristique fusce congue diam id ornare imperdiet sapien urna pretium nisl ut volutpat sapien arcu sed augue aliquam erat volutpat in congue etiam justo etiam pretium iaculis justo in hac habitasse platea dictumst etiam faucibus cursus urna ut tellus nulla ut erat id mauris vulputate elementum nullam varius nulla facilisi cras non velit nec nisi vulputate nonummy maecenas', 'Finance', 'Youbridge', '€46576,35', '17420 Atwood Circle', 'Indonesia', '10/11/2018')\n" +
",(5, 'EditorI', 'Permanent', 'lectus aliquam sit amet diam in magna bibendum imperdiet nullam orci pede venenatis non sodales sed tincidunt eu felis fusce posuere felis sed lacus morbi sem mauris laoreet ut rhoncus aliquet pulvinar sed nisl nunc rhoncus dui vel sem sed sagittis nam congue risus semper porta volutpat quam pede lobortis ligula sit amet eleifend pede libero quis orci nullam molestie nibh in lectus pellentesque at nulla suspendisse potenti cras in purus eu magna vulputate luctus cum sociis natoque penatibus et magnis dis parturient montes nascetur ridiculus mus vivamus vestibulum sagittis sapien cum sociis natoque penatibus et magnis dis parturient montes nascetur ridiculus mus etiam vel augue vestibulum rutrum rutrum neque aenean auctor gravida', 'Transportation', 'Nlounge', '¥37770.63', '8 Northridge Alley', 'Zimbabwe', '6/25/2018')\n" +
",(6, 'Human Resources Assistant II', 'Temporary', 'ultrices posuere cubilia curae mauris viverra diam vitae quam suspendisse potenti nullam porttitor lacus at turpis donec posuere metus vitae ipsum aliquam non mauris morbi non lectus aliquam sit amet diam in magna bibendum imperdiet nullam orci pede venenatis non sodales sed tincidunt eu felis fusce posuere felis sed lacus morbi', 'Construction', 'Wikizz', '€77050,01', '8 Cardinal Court', 'United States', '1/3/2019')\n" +
",(7, 'Assistant Manager', 'Internship', 'nisi volutpat eleifend donec ut dolor morbi vel lectus in quam fringilla rhoncus mauris enim leo rhoncus sed vestibulum sit amet cursus id turpis integer aliquet massa id lobortis convallis tortor risus dapibus augue vel accumsan tellus nisi eu orci mauris lacinia sapien quis libero nullam sit amet turpis elementum ligula vehicula consequat morbi a ipsum integer a nibh in', 'Transportation', 'Kwinu', '£89039.78', '22 Grayhawk Park', 'Portugal', '6/29/2018')\n" +
",(8, 'Speech Pathologist', 'Temporary', 'eget massa tempor convallis nulla neque libero convallis eget eleifend luctus ultricies eu nibh quisque id justo sit amet sapien dignissim vestibulum vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae nulla dapibus dolor vel est donec odio justo sollicitudin ut suscipit a feugiat et eros vestibulum ac est lacinia nisi venenatis tristique fusce congue diam id ornare imperdiet sapien urna pretium nisl ut volutpat sapien arcu sed augue aliquam erat volutpat in congue etiam justo etiam pretium iaculis justo in hac habitasse platea dictumst etiam faucibus cursus urna ut tellus nulla ut erat id mauris vulputate elementum nullam varius nulla facilisi cras non velit nec nisi vulputate', 'Public Utilities', 'Geba', '€96274,63', '099 International Pass', 'South Africa', '8/19/2018')\n" +
",(9, 'Software Consultant', 'Internship', 'magna vestibulum aliquet ultrices erat tortor sollicitudin mi sit amet lobortis sapien sapien non mi integer ac neque duis bibendum morbi non quam nec dui luctus rutrum nulla tellus in sagittis dui vel nisl duis ac nibh fusce lacus purus aliquet at feugiat non pretium quis lectus suspendisse potenti in eleifend quam a odio in hac habitasse platea dictumst maecenas ut massa quis augue luctus tincidunt nulla mollis molestie lorem quisque', 'Construction', 'Wordpedia', '¥74679.28', '13 4th Alley', 'Indonesia', '6/4/2018')\n" +
",(10, 'Account Coordinator', 'Full_Time', 'elementum nullam varius nulla facilisi cras non velit nec nisi vulputate nonummy maecenas tincidunt lacus at velit vivamus vel nulla eget eros elementum pellentesque quisque porta volutpat erat quisque erat eros viverra eget congue eget semper rutrum nulla nunc purus phasellus in felis donec semper sapien a libero nam dui proin leo odio porttitor id consequat in consequat ut nulla sed accumsan felis ut at dolor quis odio consequat varius integer ac leo pellentesque ultrices mattis odio donec vitae nisi nam ultrices libero non mattis pulvinar', 'Public Utilities', 'Talane', '$68244.83', '8 Susan Street', 'Philippines', '5/17/2018')\n" +
",(11, 'Quality Engineer', 'Internship', 'pede ac diam cras pellentesque volutpat dui maecenas tristique est et tempus semper est quam pharetra magna ac consequat metus sapien ut nunc vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae mauris viverra diam vitae quam suspendisse potenti nullam porttitor lacus at turpis donec posuere metus vitae', 'Transportation', 'Centidel', '¥71951.62', '99 Crescent Oaks Center', 'Iran', '6/29/2018')\n" +
",(12, 'Web Designer II', 'Temporary', 'fermentum donec ut mauris eget massa tempor convallis nulla neque libero convallis eget eleifend luctus ultricies eu nibh quisque id justo sit amet sapien dignissim vestibulum vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae nulla dapibus dolor vel est donec odio justo sollicitudin ut suscipit a feugiat et eros vestibulum ac est lacinia nisi venenatis tristique fusce', 'Public Utilities', 'Twimbo', '¥49205.44', '20 Pawling Plaza', 'France', '5/21/2018')\n" +
",(13, 'Safety Technician I', 'Permanent', 'interdum mauris non ligula pellentesque ultrices phasellus id sapien in sapien iaculis congue vivamus metus arcu adipiscing molestie hendrerit at vulputate vitae nisl aenean lectus pellentesque eget nunc donec quis orci eget orci vehicula condimentum curabitur in libero ut massa volutpat convallis morbi odio odio elementum eu interdum eu tincidunt in leo maecenas pulvinar lobortis est phasellus sit amet erat nulla tempus vivamus in felis eu sapien cursus vestibulum proin eu mi nulla ac enim in tempor turpis nec euismod scelerisque quam turpis adipiscing lorem vitae mattis nibh ligula nec sem duis aliquam convallis nunc proin at turpis a pede posuere nonummy integer non velit donec diam neque vestibulum eget vulputate ut ultrices vel', 'Construction', 'Skippad', '£21267.37', '9297 Fairview Way', 'Brazil', '9/2/2018')\n" +
",(14, 'Research Assistant II', 'Internship', 'nunc rhoncus dui vel sem sed sagittis nam congue risus semper porta volutpat quam pede lobortis ligula sit amet eleifend pede libero quis orci nullam molestie nibh in lectus pellentesque at nulla suspendisse potenti cras in purus eu magna vulputate luctus cum sociis natoque penatibus et magnis dis parturient montes nascetur ridiculus mus vivamus vestibulum sagittis sapien cum sociis', 'Consumer Services', 'Thoughtbeat', '£63750.84', '7230 Merchant Trail', 'France', '4/5/2018')\n" +
",(15, 'Staff Accountant IV', 'Part_Time', 'sed ante vivamus tortor duis mattis egestas metus aenean fermentum donec ut mauris eget massa tempor convallis nulla neque libero convallis eget eleifend luctus ultricies eu nibh quisque id justo sit amet sapien dignissim vestibulum vestibulum ante ipsum primis in faucibus orci luctus et ultrices', 'Finance', 'Fliptune', '£87977.62', '0407 Bashford Circle', 'Sweden', '4/8/2018')\n" +
",(16, 'Staff Scientist', 'Full_Time', 'augue vel accumsan tellus nisi eu orci mauris lacinia sapien quis libero nullam sit amet turpis elementum ligula vehicula consequat morbi a ipsum integer a nibh in quis justo maecenas rhoncus aliquam lacus morbi quis tortor id nulla ultrices aliquet maecenas leo odio condimentum id', 'Consumer Services', 'Jaxworks', '£28974.44', '1 Summer Ridge Point', 'Ukraine', '11/24/2018')\n" +
",(17, 'Project Manager', 'Full_Time', 'luctus et ultrices posuere cubilia curae donec pharetra magna vestibulum aliquet ultrices erat tortor sollicitudin mi sit amet lobortis sapien sapien non mi integer ac neque duis bibendum morbi non quam nec dui luctus rutrum nulla tellus in sagittis dui vel nisl duis ac nibh fusce lacus purus aliquet at feugiat non pretium quis lectus suspendisse potenti in eleifend quam a odio in hac habitasse platea dictumst maecenas ut massa quis augue luctus tincidunt nulla mollis molestie lorem quisque ut erat curabitur gravida nisi at nibh in hac habitasse platea dictumst aliquam augue quam sollicitudin vitae consectetuer eget rutrum at lorem integer tincidunt ante vel ipsum praesent blandit lacinia erat vestibulum sed magna at nunc commodo placerat praesent', 'Construction', 'Edgeify', '$89061.03', '51 Grayhawk Terrace', 'Armenia', '10/18/2018')\n" +
",(18, 'Civil Engineer', 'Full_Time', 'id pretium iaculis diam erat fermentum justo nec condimentum neque sapien placerat ante nulla justo aliquam quis turpis eget elit sodales scelerisque mauris sit amet eros suspendisse accumsan tortor quis turpis sed ante vivamus tortor duis mattis egestas metus aenean fermentum donec ut mauris eget massa tempor convallis nulla neque libero convallis eget eleifend luctus ultricies eu nibh quisque id justo', 'Transportation', 'Ailane', '£82681.39', '17 High Crossing Park', 'Poland', '2/22/2019')\n" +
",(19, 'Editor', 'Part_Time', 'accumsan odio curabitur convallis duis consequat dui nec nisi volutpat eleifend donec ut dolor morbi vel lectus in quam fringilla rhoncus mauris enim leo rhoncus sed vestibulum sit amet cursus id turpis integer aliquet massa id lobortis convallis tortor risus dapibus augue vel accumsan tellus nisi eu orci mauris lacinia sapien', 'Construction', 'Realcube', '€85928,20', '1 Gale Point', 'Sweden', '10/6/2018')\n" +
",(20, 'Safety Technician IV', 'Temporary', 'curae duis faucibus accumsan odio curabitur convallis duis consequat dui nec nisi volutpat eleifend donec ut dolor morbi vel lectus in quam fringilla rhoncus mauris enim leo rhoncus sed vestibulum sit amet cursus id turpis integer aliquet massa id lobortis convallis tortor risus dapibus augue vel accumsan tellus nisi eu orci mauris lacinia sapien quis libero nullam sit amet turpis elementum ligula vehicula consequat morbi a ipsum integer a nibh in quis justo maecenas rhoncus aliquam lacus morbi quis tortor id nulla ultrices aliquet maecenas leo odio condimentum id luctus nec molestie sed justo pellentesque viverra pede ac diam cras pellentesque volutpat dui maecenas tristique est et tempus semper est quam pharetra magna ac consequat metus sapien ut nunc vestibulum ante', 'Construction', 'Roombo', '$40208.86', '8983 Carey Avenue', 'Jordan', '2/25/2019')\n" +
",(21, 'Editor', 'Temporary', 'dictumst aliquam augue quam sollicitudin vitae consectetuer eget rutrum at lorem integer tincidunt ante vel ipsum praesent blandit lacinia erat vestibulum sed magna at nunc commodo placerat praesent blandit nam nulla integer pede justo lacinia eget tincidunt eget tempus vel pede morbi porttitor lorem id ligula suspendisse ornare consequat lectus in est risus auctor sed tristique in tempus sit amet sem fusce consequat nulla nisl nunc nisl duis bibendum felis sed interdum venenatis turpis enim blandit mi in porttitor pede justo eu massa donec dapibus duis at velit eu est congue elementum in hac habitasse platea dictumst morbi vestibulum velit id pretium iaculis diam', 'Transportation', 'Zoonder', '£53491.47', '3 Onsgard Circle', 'Brazil', '4/16/2018')\n" +
",(22, 'Compensation Analyst', 'Permanent', 'nisl ut volutpat sapien arcu sed augue aliquam erat volutpat in congue etiam justo etiam pretium iaculis justo in hac habitasse platea dictumst etiam faucibus cursus urna ut tellus nulla ut erat id mauris vulputate elementum nullam varius nulla facilisi cras non velit nec nisi vulputate nonummy maecenas tincidunt lacus at velit vivamus vel nulla eget eros elementum pellentesque quisque porta', 'Finance', 'Meevee', '¥53831.28', '40 Nevada Hill', 'Portugal', '10/5/2018')\n" +
",(23, 'General Manager', 'Internship', 'tortor risus dapibus augue vel accumsan tellus nisi eu orci mauris lacinia sapien quis libero nullam sit amet turpis elementum ligula vehicula consequat morbi a ipsum integer a nibh in quis justo maecenas rhoncus aliquam lacus morbi quis tortor id nulla ultrices aliquet maecenas leo odio condimentum id luctus nec molestie sed justo pellentesque viverra pede ac diam cras pellentesque volutpat dui maecenas tristique est et tempus semper est quam', 'Public Utilities', 'Twitterwire', '¥41962.10', '58 Declaration Avenue', 'Ukraine', '2/16/2019')\n" +
",(24, 'Software Engineer IV', 'Temporary', 'eu massa donec dapibus duis at velit eu est congue elementum in hac habitasse platea dictumst morbi vestibulum velit id pretium iaculis diam erat fermentum justo nec condimentum neque sapien placerat ante nulla justo aliquam quis turpis eget elit sodales', 'Consumer Services', 'Ooba', '$81273.24', '4660 Messerschmidt Court', 'Portugal', '4/5/2018')\n" +
",(25, 'Nuclear Power Engineer', 'Temporary', 'eu felis fusce posuere felis sed lacus morbi sem mauris laoreet ut rhoncus aliquet pulvinar sed nisl nunc rhoncus dui vel sem sed sagittis nam congue risus semper porta volutpat quam pede lobortis ligula sit amet eleifend pede libero quis orci nullam molestie nibh in lectus pellentesque', 'Public Utilities', 'Kanoodle', '$72950.24', '53 Erie Road', 'Germany', '2/7/2019')\n" +
",(26, 'Editor', 'Permanent', 'in faucibus orci luctus et ultrices posuere cubilia curae nulla dapibus dolor vel est donec odio justo sollicitudin ut suscipit a feugiat et eros vestibulum ac est lacinia nisi venenatis tristique fusce congue diam id ornare imperdiet sapien urna pretium nisl ut volutpat sapien arcu sed augue aliquam erat volutpat in congue etiam justo etiam pretium iaculis justo in hac habitasse platea dictumst etiam faucibus cursus urna ut tellus nulla ut erat', 'Transportation', 'Jamia', '€35797,80', '02842 Kings Lane', 'United States', '3/13/2019')\n" +
",(27, 'Senior Developer', 'Permanent', 'faucibus accumsan odio curabitur convallis duis consequat dui nec nisi volutpat eleifend donec ut dolor morbi vel lectus in quam fringilla rhoncus mauris enim leo rhoncus sed vestibulum sit amet cursus id turpis integer aliquet massa id lobortis convallis tortor risus dapibus augue vel accumsan tellus nisi eu orci mauris lacinia sapien quis libero nullam sit amet turpis elementum ligula vehicula consequat morbi a ipsum integer a nibh in quis justo maecenas rhoncus aliquam lacus morbi quis tortor id nulla ultrices aliquet maecenas leo odio condimentum id luctus nec molestie sed justo pellentesque viverra pede ac diam cras pellentesque volutpat dui maecenas tristique est et tempus semper est quam pharetra magna ac consequat metus sapien ut nunc vestibulum ante ipsum', 'Finance', 'Dazzlesphere', '€65319,57', '948 Victoria Crossing', 'Colombia', '2/11/2019')\n" +
",(28, 'Computer Systems Analyst III', 'Temporary', 'feugiat et eros vestibulum ac est lacinia nisi venenatis tristique fusce congue diam id ornare imperdiet sapien urna pretium nisl ut volutpat sapien arcu sed augue aliquam erat volutpat in congue etiam justo etiam pretium iaculis justo in hac habitasse platea dictumst etiam faucibus cursus urna ut tellus nulla ut erat id mauris vulputate elementum nullam varius nulla facilisi cras non velit nec nisi vulputate nonummy maecenas tincidunt lacus at velit vivamus vel nulla eget eros elementum pellentesque quisque porta volutpat erat quisque erat eros viverra', 'Finance', 'Twitterwire', '¥92997.80', '347 Morningstar Place', 'Bulgaria', '7/7/2018')\n" +
",(29, 'Teacher', 'Full_Time', 'orci luctus et ultrices posuere cubilia curae donec pharetra magna vestibulum aliquet ultrices erat tortor sollicitudin mi sit amet lobortis sapien sapien non mi integer ac neque duis bibendum morbi non quam nec dui luctus rutrum nulla tellus in sagittis dui vel nisl duis ac nibh fusce lacus purus aliquet at feugiat non pretium quis', 'Basic Industries', 'Jatri', '€21948,56', '91275 Northfield Junction', 'Indonesia', '7/1/2018')\n" +
",(30, 'Librarian', 'Full_Time', 'in sagittis dui vel nisl duis ac nibh fusce lacus purus aliquet at feugiat non pretium quis lectus suspendisse potenti in eleifend quam a odio in hac habitasse platea dictumst maecenas ut massa quis augue luctus tincidunt nulla mollis molestie lorem quisque ut erat curabitur gravida nisi at nibh in hac habitasse platea dictumst aliquam augue quam sollicitudin vitae consectetuer eget rutrum at lorem integer tincidunt ante vel ipsum praesent blandit lacinia erat vestibulum sed magna at nunc commodo placerat praesent blandit nam nulla integer pede justo lacinia eget tincidunt eget tempus vel pede morbi porttitor lorem id ligula suspendisse ornare consequat lectus in est risus auctor sed tristique in tempus sit amet sem fusce consequat nulla', 'Transportation', 'Gigaclub', '€88099,94', '68 Reindahl Parkway', 'Indonesia', '10/10/2018')\n" +
",(31, 'Occupational Therapist', 'Part_Time', 'sed augue aliquam erat volutpat in congue etiam justo etiam pretium iaculis justo in hac habitasse platea dictumst etiam faucibus cursus urna ut tellus nulla ut erat id mauris vulputate elementum nullam varius nulla facilisi cras non velit nec nisi vulputate nonummy maecenas tincidunt', 'Consumer Services', 'Kwimbee', '¥74511.40', '62 Sachs Drive', 'New Zealand', '5/11/2018')\n" +
",(32, 'Desktop Support Technician', 'Internship', 'lacinia nisi venenatis tristique fusce congue diam id ornare imperdiet sapien urna pretium nisl ut volutpat sapien arcu sed augue aliquam erat volutpat in congue etiam justo etiam pretium iaculis justo in hac habitasse platea dictumst etiam faucibus cursus urna ut tellus nulla ut erat id mauris vulputate elementum nullam varius nulla facilisi cras non velit nec nisi vulputate', 'Consumer Services', 'Flipopia', '€89926,79', '6 Randy Terrace', 'Germany', '5/3/2018')\n" +
",(33, 'Financial Analyst', 'Full_Time', 'ut blandit non interdum in ante vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae duis faucibus accumsan odio curabitur convallis duis consequat dui nec nisi volutpat eleifend donec ut dolor morbi vel lectus in quam fringilla rhoncus mauris enim leo rhoncus sed vestibulum sit amet cursus id turpis integer aliquet massa id lobortis convallis tortor risus dapibus augue vel accumsan tellus nisi eu orci mauris lacinia sapien quis libero nullam sit amet turpis elementum ligula vehicula consequat morbi a ipsum integer a nibh in quis justo maecenas rhoncus aliquam lacus morbi quis tortor id nulla ultrices aliquet maecenas leo odio condimentum id luctus nec molestie sed justo pellentesque viverra', 'Transportation', 'Feednation', '€64667,63', '464 Petterle Street', 'China', '4/19/2018')\n" +
",(34, 'Senior Cost Accountant', 'Permanent', 'ac diam cras pellentesque volutpat dui maecenas tristique est et tempus semper est quam pharetra magna ac consequat metus sapien ut nunc vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae mauris viverra diam vitae quam suspendisse potenti nullam porttitor lacus at turpis donec posuere metus vitae ipsum aliquam non mauris morbi non lectus aliquam sit amet diam in magna bibendum imperdiet nullam orci pede venenatis non sodales sed tincidunt eu felis fusce posuere felis sed lacus morbi sem mauris laoreet ut rhoncus aliquet pulvinar sed nisl nunc rhoncus dui vel sem sed sagittis nam congue risus semper porta volutpat quam pede lobortis ligula sit amet eleifend pede libero quis orci nullam molestie nibh in lectus pellentesque at', 'Finance', 'Thoughtsphere', '€77928,80', '6786 Melrose Road', 'China', '4/15/2018')\n" +
",(35, 'Analog Circuit Design manager', 'Permanent', 'in porttitor pede justo eu massa donec dapibus duis at velit eu est congue elementum in hac habitasse platea dictumst morbi vestibulum velit id pretium iaculis diam erat fermentum justo nec condimentum neque sapien placerat ante nulla justo aliquam quis turpis eget elit sodales scelerisque mauris sit amet eros suspendisse accumsan tortor quis turpis sed ante vivamus tortor duis mattis egestas metus aenean fermentum donec ut mauris eget massa tempor convallis nulla neque libero convallis eget eleifend luctus ultricies eu nibh quisque id justo sit amet', 'Basic Industries', 'Digitube', '¥87449.88', '367 Golf View Avenue', 'Libya', '4/13/2018')\n" +
",(36, 'Clinical Specialist', 'Permanent', 'at feugiat non pretium quis lectus suspendisse potenti in eleifend quam a odio in hac habitasse platea dictumst maecenas ut massa quis augue luctus tincidunt nulla mollis molestie lorem quisque ut erat curabitur gravida nisi at nibh in hac habitasse platea dictumst aliquam augue quam sollicitudin vitae consectetuer eget rutrum at lorem integer tincidunt ante vel ipsum praesent blandit lacinia erat vestibulum sed magna at nunc commodo placerat praesent blandit nam nulla integer pede justo lacinia eget tincidunt eget tempus vel pede morbi porttitor lorem id ligula suspendisse ornare consequat lectus in est risus auctor sed tristique in tempus sit amet sem fusce', 'Consumer Services', 'Geba', '¥27075.22', '22 Mesta Alley', 'Brazil', '5/30/2018')\n" +
",(37, 'Quality Engineer', 'Permanent', 'in leo maecenas pulvinar lobortis est phasellus sit amet erat nulla tempus vivamus in felis eu sapien cursus vestibulum proin eu mi nulla ac enim in tempor turpis nec euismod scelerisque quam turpis adipiscing lorem vitae mattis nibh ligula nec sem duis aliquam convallis nunc proin at turpis a pede posuere nonummy integer non velit donec diam neque vestibulum eget vulputate ut ultrices vel augue vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae donec pharetra magna vestibulum aliquet ultrices erat tortor sollicitudin mi sit amet lobortis sapien sapien non mi integer ac neque duis bibendum morbi non quam nec dui luctus rutrum nulla tellus in', 'Transportation', 'Gigashots', '€35687,90', '67808 Lakewood Park', 'Indonesia', '12/9/2018')\n" +
",(38, 'Legal Assistant', 'Part_Time', 'magnis dis parturient montes nascetur ridiculus mus etiam vel augue vestibulum rutrum rutrum neque aenean auctor gravida sem praesent id massa id nisl venenatis lacinia aenean sit amet justo morbi ut odio cras mi pede malesuada in imperdiet et commodo vulputate justo in blandit ultrices enim lorem ipsum dolor sit amet consectetuer adipiscing elit proin interdum mauris non ligula pellentesque ultrices phasellus id sapien in sapien iaculis congue vivamus metus arcu adipiscing molestie hendrerit at vulputate vitae nisl aenean lectus pellentesque eget nunc donec quis orci eget orci vehicula condimentum curabitur in libero ut massa volutpat convallis morbi odio odio elementum eu interdum eu tincidunt in leo', 'Finance', 'Photofeed', '¥80078.96', '33450 Acker Point', 'North Korea', '7/13/2018')\n" +
",(39, 'Web Developer III', 'Full_Time', 'in magna bibendum imperdiet nullam orci pede venenatis non sodales sed tincidunt eu felis fusce posuere felis sed lacus morbi sem mauris laoreet ut rhoncus aliquet pulvinar sed nisl nunc rhoncus dui vel sem sed sagittis nam congue risus semper porta volutpat quam pede lobortis ligula sit amet eleifend pede libero quis orci nullam molestie nibh in lectus pellentesque at nulla suspendisse potenti cras in purus eu magna vulputate luctus cum sociis natoque penatibus et magnis dis parturient montes nascetur ridiculus mus vivamus vestibulum sagittis sapien cum sociis natoque penatibus et magnis dis parturient', 'Finance', 'Tavu', '¥64945.78', '00 Lighthouse Bay Lane', 'Cameroon', '7/21/2018')\n" +
",(40, 'Junior Executive', 'Permanent', 'pede lobortis ligula sit amet eleifend pede libero quis orci nullam molestie nibh in lectus pellentesque at nulla suspendisse potenti cras in purus eu magna vulputate luctus cum sociis natoque penatibus et magnis dis parturient montes nascetur ridiculus mus vivamus vestibulum sagittis sapien cum sociis natoque penatibus et magnis dis parturient montes nascetur ridiculus mus etiam vel augue', 'Public Utilities', 'Mynte', '¥91848.44', '28635 Erie Street', 'Russia', '10/5/2018')\n" +
",(41, 'GIS Technical Architect', 'Internship', 'et magnis dis parturient montes nascetur ridiculus mus etiam vel augue vestibulum rutrum rutrum neque aenean auctor gravida sem praesent id massa id nisl venenatis lacinia aenean sit amet justo morbi ut odio cras mi pede malesuada in imperdiet et commodo vulputate justo in blandit ultrices enim lorem ipsum dolor sit amet consectetuer adipiscing elit proin interdum mauris non ligula pellentesque ultrices phasellus id sapien in sapien iaculis congue vivamus metus arcu adipiscing molestie hendrerit at vulputate vitae nisl aenean lectus pellentesque eget nunc donec quis orci eget orci vehicula condimentum curabitur in libero ut massa volutpat convallis morbi odio odio elementum eu interdum', 'Finance', 'Ooba', '¥25880.53', '4044 Park Meadow Plaza', 'United States', '3/31/2018')\n" +
",(42, 'Marketing Assistant', 'Part_Time', 'sit amet cursus id turpis integer aliquet massa id lobortis convallis tortor risus dapibus augue vel accumsan tellus nisi eu orci mauris lacinia sapien quis libero nullam sit amet turpis elementum ligula vehicula consequat morbi a ipsum integer a nibh in quis justo maecenas rhoncus aliquam lacus morbi quis tortor', 'Public Utilities', 'Npath', '$94790.16', '41 Grasskamp Drive', 'Peru', '6/30/2018')\n" +
",(43, 'Media Manager III', 'Permanent', 'aliquet at feugiat non pretium quis lectus suspendisse potenti in eleifend quam a odio in hac habitasse platea dictumst maecenas ut massa quis augue luctus tincidunt nulla mollis molestie lorem quisque ut erat curabitur gravida nisi at nibh in hac habitasse platea dictumst aliquam augue quam sollicitudin vitae consectetuer eget rutrum at lorem integer tincidunt ante vel ipsum praesent blandit lacinia erat vestibulum sed magna at nunc commodo placerat praesent blandit nam nulla integer pede justo lacinia eget tincidunt eget tempus', 'Basic Industries', 'Viva', '$32649.88', '62 Randy Road', 'Indonesia', '5/24/2018')\n" +
",(44, 'Senior Financial Analyst', 'Temporary', 'sed magna at nunc commodo placerat praesent blandit nam nulla integer pede justo lacinia eget tincidunt eget tempus vel pede morbi porttitor lorem id ligula suspendisse ornare consequat lectus in est risus auctor sed tristique in tempus sit amet sem fusce consequat nulla nisl', 'Finance', 'Babbleblab', '¥67192.22', '85 Vernon Circle', 'Guatemala', '4/29/2018')\n" +
",(45, 'Clinical Specialist', 'Internship', 'feugiat et eros vestibulum ac est lacinia nisi venenatis tristique fusce congue diam id ornare imperdiet sapien urna pretium nisl ut volutpat sapien arcu sed augue aliquam erat volutpat in congue etiam justo etiam pretium iaculis justo in hac habitasse platea dictumst etiam faucibus cursus urna ut tellus nulla ut erat id mauris vulputate elementum nullam varius', 'Transportation', 'Viva', '$35828.44', '15505 Crowley Place', 'Afghanistan', '2/2/2019')\n" +
",(46, 'Staff Scientist', 'Part_Time', 'varius integer ac leo pellentesque ultrices mattis odio donec vitae nisi nam ultrices libero non mattis pulvinar nulla pede ullamcorper augue a suscipit nulla elit ac nulla sed vel enim sit amet nunc viverra dapibus nulla suscipit ligula in lacus curabitur at ipsum ac tellus semper interdum mauris ullamcorper purus sit', 'Transportation', 'Mydeo', '¥26930.75', '49960 Northview Lane', 'China', '11/5/2018')\n" +
",(47, 'Clinical Specialist', 'Full_Time', 'integer tincidunt ante vel ipsum praesent blandit lacinia erat vestibulum sed magna at nunc commodo placerat praesent blandit nam nulla integer pede justo lacinia eget tincidunt eget tempus vel pede morbi porttitor lorem id ligula suspendisse ornare consequat lectus in est risus auctor sed tristique in tempus sit amet sem fusce consequat nulla nisl nunc nisl duis bibendum felis sed interdum venenatis turpis enim blandit mi in porttitor pede justo eu massa donec dapibus duis at velit eu est congue elementum in hac habitasse platea dictumst morbi vestibulum velit id pretium iaculis diam erat fermentum justo nec condimentum neque sapien placerat ante nulla justo aliquam quis turpis eget elit sodales scelerisque mauris sit amet eros suspendisse accumsan tortor quis turpis sed ante', 'Public Utilities', 'Vitz', '£21981.38', '874 Ruskin Avenue', 'Portugal', '11/2/2018')\n" +
",(48, 'Community Outreach Specialist', 'Full_Time', 'sapien a libero nam dui proin leo odio porttitor id consequat in consequat ut nulla sed accumsan felis ut at dolor quis odio consequat varius integer ac leo pellentesque ultrices mattis odio donec vitae nisi nam ultrices libero non mattis pulvinar nulla pede ullamcorper augue a suscipit nulla elit ac nulla sed vel enim sit amet nunc viverra dapibus nulla suscipit ligula in lacus curabitur at ipsum ac tellus semper interdum mauris ullamcorper purus sit amet nulla quisque arcu', 'Basic Industries', 'Brightbean', '$75946.59', '374 Heffernan Way', 'Chile', '8/8/2018')\n" +
",(49, 'Biostatistician II', 'Internship', 'lacus at turpis donec posuere metus vitae ipsum aliquam non mauris morbi non lectus aliquam sit amet diam in magna bibendum imperdiet nullam orci pede venenatis non sodales sed tincidunt eu felis fusce posuere felis sed lacus morbi sem mauris laoreet ut rhoncus aliquet pulvinar sed nisl nunc rhoncus dui vel sem sed sagittis nam congue risus semper porta volutpat quam pede lobortis ligula sit amet eleifend pede libero quis orci', 'Consumer Services', 'Jabberbean', '$62679.27', '8267 Orin Hill', 'Mexico', '1/13/2019')\n" +
",(50, 'Business Systems Development Analyst', 'Part_Time', 'volutpat eleifend donec ut dolor morbi vel lectus in quam fringilla rhoncus mauris enim leo rhoncus sed vestibulum sit amet cursus id turpis integer aliquet massa id lobortis convallis tortor risus dapibus augue vel accumsan tellus nisi eu orci mauris lacinia sapien quis libero nullam sit amet turpis elementum ligula vehicula consequat morbi a ipsum integer a nibh in quis justo maecenas rhoncus aliquam lacus morbi quis tortor id nulla', 'Public Utilities', 'Blogtag', '€55948,12', '1818 Claremont Road', 'China', '3/30/2018')\n" +
",(51, 'Junior Executive', 'Full_Time', 'eget massa tempor convallis nulla neque libero convallis eget eleifend luctus ultricies eu nibh quisque id justo sit amet sapien dignissim vestibulum vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae nulla dapibus dolor vel est donec odio justo sollicitudin ut suscipit a feugiat et eros vestibulum ac est lacinia nisi venenatis tristique fusce congue diam id ornare imperdiet sapien urna pretium nisl ut volutpat sapien arcu sed augue aliquam erat volutpat in congue etiam justo etiam pretium iaculis justo in hac habitasse platea dictumst etiam faucibus cursus urna ut tellus nulla ut erat id mauris vulputate elementum nullam', 'Transportation', 'Brainlounge', '$29598.60', '95903 Graceland Crossing', 'Bulgaria', '3/11/2019')\n" +
",(52, 'Editor', 'Internship', 'id lobortis convallis tortor risus dapibus augue vel accumsan tellus nisi eu orci mauris lacinia sapien quis libero nullam sit amet turpis elementum ligula vehicula consequat morbi a ipsum integer a nibh in quis justo maecenas rhoncus aliquam lacus morbi quis tortor id nulla ultrices aliquet maecenas leo odio condimentum id luctus nec molestie sed justo pellentesque viverra pede ac', 'Construction', 'Twitterbridge', '£66072.58', '5122 Dakota Plaza', 'Uzbekistan', '3/30/2018')\n" +
",(53, 'Programmer II', 'Temporary', 'sapien sapien non mi integer ac neque duis bibendum morbi non quam nec dui luctus rutrum nulla tellus in sagittis dui vel nisl duis ac nibh fusce lacus purus aliquet at feugiat non pretium quis lectus suspendisse potenti in eleifend quam a odio in hac habitasse platea dictumst maecenas ut massa quis augue luctus tincidunt nulla mollis molestie lorem quisque ut erat curabitur gravida nisi at nibh in hac habitasse platea dictumst aliquam augue quam sollicitudin vitae consectetuer eget rutrum', 'Consumer Services', 'Innojam', '¥90339.90', '790 Corry Plaza', 'Slovenia', '1/26/2019')\n" +
",(54, 'Help Desk Technician', 'Internship', 'vestibulum vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae nulla dapibus dolor vel est donec odio justo sollicitudin ut suscipit a feugiat et eros vestibulum ac est lacinia nisi venenatis tristique fusce congue diam id ornare imperdiet sapien urna pretium nisl ut volutpat sapien arcu sed augue aliquam erat volutpat in congue etiam justo etiam pretium iaculis justo in hac habitasse platea dictumst etiam faucibus cursus urna ut tellus nulla ut erat id mauris vulputate elementum nullam varius nulla facilisi cras non velit nec nisi vulputate nonummy maecenas tincidunt lacus at velit vivamus vel nulla eget eros elementum pellentesque quisque porta volutpat erat quisque erat eros viverra eget congue eget semper rutrum nulla nunc', 'Public Utilities', 'Skaboo', '¥92735.45', '52220 Lunder Center', 'Nepal', '12/15/2018')\n" +
",(55, 'Executive Secretary', 'Internship', 'eget congue eget semper rutrum nulla nunc purus phasellus in felis donec semper sapien a libero nam dui proin leo odio porttitor id consequat in consequat ut nulla sed accumsan felis ut at dolor quis odio consequat varius integer ac leo pellentesque ultrices mattis odio donec vitae nisi nam ultrices libero non mattis pulvinar nulla pede ullamcorper augue a suscipit', 'Basic Industries', 'Yata', '€45992,43', '87016 Twin Pines Center', 'Brazil', '9/21/2018')\n" +
",(56, 'Cost Accountant', 'Temporary', 'bibendum imperdiet nullam orci pede venenatis non sodales sed tincidunt eu felis fusce posuere felis sed lacus morbi sem mauris laoreet ut rhoncus aliquet pulvinar sed nisl nunc rhoncus dui vel sem sed sagittis nam congue risus semper porta volutpat quam pede lobortis ligula sit amet eleifend pede libero quis orci nullam molestie nibh in lectus pellentesque at nulla suspendisse potenti cras in purus eu magna vulputate luctus cum sociis natoque penatibus et magnis dis parturient montes nascetur ridiculus mus vivamus vestibulum sagittis sapien cum sociis natoque penatibus et magnis dis parturient montes nascetur ridiculus mus etiam vel augue vestibulum rutrum rutrum neque aenean auctor gravida sem praesent', 'Public Utilities', 'Kayveo', '¥92069.93', '8 Summit Pass', 'China', '7/13/2018')\n" +
",(57, 'Physical Therapy Assistant', 'Full_Time', 'quisque ut erat curabitur gravida nisi at nibh in hac habitasse platea dictumst aliquam augue quam sollicitudin vitae consectetuer eget rutrum at lorem integer tincidunt ante vel ipsum praesent blandit lacinia erat vestibulum sed magna at nunc commodo placerat praesent blandit nam nulla integer pede justo lacinia eget tincidunt eget tempus vel pede morbi porttitor lorem id ligula suspendisse ornare consequat lectus in est risus auctor sed tristique in tempus sit amet sem fusce consequat nulla nisl nunc nisl duis bibendum felis sed interdum venenatis turpis enim blandit mi in porttitor pede justo eu massa donec dapibus duis at velit eu est congue elementum in hac habitasse platea dictumst morbi vestibulum velit id pretium iaculis', 'Consumer Services', 'Mita', '€84387,14', '6550 Lakeland Parkway', 'Russia', '7/18/2018')\n" +
",(58, 'Quality Control Specialist', 'Full_Time', 'ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae donec pharetra magna vestibulum aliquet ultrices erat tortor sollicitudin mi sit amet lobortis sapien sapien non mi integer ac neque duis bibendum morbi non quam nec dui luctus rutrum nulla tellus in sagittis dui vel nisl duis ac nibh fusce lacus purus aliquet at feugiat non pretium quis lectus suspendisse potenti in eleifend quam a odio in hac habitasse platea dictumst maecenas ut massa quis augue luctus tincidunt nulla mollis molestie lorem quisque ut', 'Construction', 'Demimbu', '¥58440.41', '6 Stang Hill', 'Czech Republic', '4/13/2018')\n" +
",(59, 'Recruiting Manager', 'Temporary', 'erat fermentum justo nec condimentum neque sapien placerat ante nulla justo aliquam quis turpis eget elit sodales scelerisque mauris sit amet eros suspendisse accumsan tortor quis turpis sed ante vivamus tortor duis mattis egestas metus aenean fermentum donec ut mauris eget massa tempor convallis nulla neque libero convallis eget eleifend luctus ultricies eu nibh quisque id justo sit amet sapien dignissim vestibulum vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae nulla dapibus dolor vel est donec odio justo sollicitudin ut suscipit a feugiat et eros vestibulum ac est lacinia nisi venenatis tristique fusce congue diam id ornare imperdiet sapien urna pretium nisl ut volutpat sapien arcu sed augue aliquam erat', 'Consumer Services', 'Topiczoom', '€35471,47', '5 Kings Parkway', 'China', '5/27/2018')\n" +
",(60, 'Structural Engineer', 'Internship', 'eget orci vehicula condimentum curabitur in libero ut massa volutpat convallis morbi odio odio elementum eu interdum eu tincidunt in leo maecenas pulvinar lobortis est phasellus sit amet erat nulla tempus vivamus in felis eu sapien cursus vestibulum proin eu mi nulla ac enim in tempor turpis nec', 'Transportation', 'Linktype', '£97844.41', '3 Arkansas Avenue', 'Lebanon', '11/9/2018')\n" +
",(61, 'Junior Executive', 'Internship', 'tellus nisi eu orci mauris lacinia sapien quis libero nullam sit amet turpis elementum ligula vehicula consequat morbi a ipsum integer a nibh in quis justo maecenas rhoncus aliquam lacus morbi quis tortor id nulla ultrices aliquet maecenas leo odio condimentum id luctus nec molestie sed justo pellentesque viverra pede ac diam cras pellentesque volutpat dui maecenas tristique est et tempus semper est quam pharetra magna', 'Basic Industries', 'Kwideo', '$68158.15', '0 Nevada Pass', 'Azerbaijan', '5/1/2018')\n" +
",(62, 'Business Systems Development Analyst', 'Internship', 'curae nulla dapibus dolor vel est donec odio justo sollicitudin ut suscipit a feugiat et eros vestibulum ac est lacinia nisi venenatis tristique fusce congue diam id ornare imperdiet sapien urna pretium nisl ut volutpat sapien arcu sed augue aliquam erat volutpat in congue etiam justo etiam pretium iaculis justo in hac habitasse platea dictumst etiam faucibus cursus urna ut tellus nulla ut erat id mauris vulputate elementum nullam varius nulla facilisi cras non velit nec nisi vulputate nonummy maecenas tincidunt lacus at velit vivamus vel nulla eget eros elementum pellentesque quisque porta volutpat erat quisque erat eros viverra eget congue eget semper rutrum nulla nunc purus phasellus in', 'Transportation', 'Eamia', '€28107,84', '589 Mayer Pass', 'Indonesia', '10/12/2018')\n" +
",(63, 'Occupational Therapist', 'Temporary', 'fusce congue diam id ornare imperdiet sapien urna pretium nisl ut volutpat sapien arcu sed augue aliquam erat volutpat in congue etiam justo etiam pretium iaculis justo in hac habitasse platea dictumst etiam faucibus cursus urna ut tellus nulla ut erat id mauris vulputate elementum nullam varius nulla facilisi cras non velit nec nisi vulputate nonummy maecenas tincidunt lacus at velit', 'Transportation', 'Mydeo', '£50572.72', '71427 Schlimgen Way', 'Portugal', '8/30/2018')\n" +
",(64, 'Actuary', 'Temporary', 'elit sodales scelerisque mauris sit amet eros suspendisse accumsan tortor quis turpis sed ante vivamus tortor duis mattis egestas metus aenean fermentum donec ut mauris eget massa tempor convallis nulla neque libero convallis eget eleifend luctus ultricies eu nibh quisque id justo sit amet sapien dignissim vestibulum vestibulum ante ipsum', 'Finance', 'Leenti', '€77400,57', '492 Sundown Center', 'Sweden', '1/24/2019')\n" +
",(65, 'Senior Editor', 'Full_Time', 'parturient montes nascetur ridiculus mus vivamus vestibulum sagittis sapien cum sociis natoque penatibus et magnis dis parturient montes nascetur ridiculus mus etiam vel augue vestibulum rutrum rutrum neque aenean auctor gravida sem praesent id massa id nisl venenatis lacinia aenean sit amet justo morbi ut odio cras mi pede malesuada in imperdiet et commodo vulputate justo in blandit ultrices enim lorem ipsum dolor sit amet consectetuer adipiscing elit proin interdum mauris non ligula pellentesque ultrices phasellus id sapien in sapien iaculis congue vivamus metus arcu adipiscing molestie hendrerit at vulputate vitae nisl aenean lectus pellentesque eget nunc donec quis orci eget orci vehicula condimentum curabitur in libero ut massa volutpat convallis morbi odio odio elementum', 'Finance', 'Einti', '$69474.44', '1331 Farragut Center', 'Indonesia', '8/8/2018')\n" +
",(66, 'Social Worker', 'Permanent', 'nisl nunc rhoncus dui vel sem sed sagittis nam congue risus semper porta volutpat quam pede lobortis ligula sit amet eleifend pede libero quis orci nullam molestie nibh in lectus pellentesque at nulla suspendisse potenti cras in purus eu magna vulputate luctus cum sociis natoque penatibus et magnis dis parturient montes nascetur ridiculus mus vivamus vestibulum sagittis sapien cum sociis natoque penatibus et magnis dis parturient montes nascetur ridiculus', 'Public Utilities', 'Jabbersphere', '£34499.90', '6132 Burning Wood Center', 'Brazil', '9/2/2018')\n" +
",(67, 'VP Accounting', 'Temporary', 'scelerisque mauris sit amet eros suspendisse accumsan tortor quis turpis sed ante vivamus tortor duis mattis egestas metus aenean fermentum donec ut mauris eget massa tempor convallis nulla neque libero convallis eget eleifend luctus ultricies eu nibh quisque id justo sit amet sapien dignissim vestibulum vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae nulla dapibus dolor vel est donec odio justo sollicitudin ut suscipit a feugiat et eros vestibulum ac est lacinia nisi venenatis tristique fusce congue diam id ornare', 'Basic Industries', 'Buzzbean', '¥86264.87', '7729 Dovetail Alley', 'China', '6/5/2018')\n" +
",(68, 'Speech Pathologist', 'Part_Time', 'quisque porta volutpat erat quisque erat eros viverra eget congue eget semper rutrum nulla nunc purus phasellus in felis donec semper sapien a libero nam dui proin leo odio porttitor id consequat in consequat ut nulla sed accumsan felis ut at dolor quis odio consequat varius integer ac leo pellentesque ultrices mattis odio donec vitae nisi nam ultrices libero non mattis pulvinar nulla', 'Construction', 'Bluejam', '¥54156.79', '7 Cambridge Center', 'Russia', '3/25/2018')\n" +
",(69, 'Research Assistant II', 'Part_Time', 'convallis nunc proin at turpis a pede posuere nonummy integer non velit donec diam neque vestibulum eget vulputate ut ultrices vel augue vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae donec pharetra magna vestibulum aliquet ultrices erat tortor sollicitudin mi sit', 'Basic Industries', 'Buzzster', '¥87076.60', '736 Ridgeway Way', 'Brazil', '4/21/2018')\n" +
",(70, 'Structural Engineer', 'Part_Time', 'amet eros suspendisse accumsan tortor quis turpis sed ante vivamus tortor duis mattis egestas metus aenean fermentum donec ut mauris eget massa tempor convallis nulla neque libero convallis eget eleifend luctus ultricies eu nibh quisque id justo sit amet sapien dignissim vestibulum vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae nulla dapibus dolor vel est donec odio justo sollicitudin ut suscipit a feugiat et eros vestibulum ac est lacinia nisi venenatis tristique fusce congue diam id ornare imperdiet sapien urna pretium nisl', 'Finance', 'Roodel', '€40946,89', '90648 Veith Parkway', 'Indonesia', '10/21/2018')\n" +
",(71, 'Desktop Support Technician', 'Full_Time', 'et magnis dis parturient montes nascetur ridiculus mus vivamus vestibulum sagittis sapien cum sociis natoque penatibus et magnis dis parturient montes nascetur ridiculus mus etiam vel augue vestibulum rutrum rutrum neque aenean auctor gravida sem praesent id massa id nisl venenatis lacinia aenean sit amet justo morbi ut odio cras mi pede malesuada in imperdiet', 'Consumer Services', 'Flashpoint', '¥34914.42', '064 Fair Oaks Avenue', 'Argentina', '11/28/2018')\n" +
",(72, 'Assistant Media Planner', 'Permanent', 'montes nascetur ridiculus mus etiam vel augue vestibulum rutrum rutrum neque aenean auctor gravida sem praesent id massa id nisl venenatis lacinia aenean sit amet justo morbi ut odio cras mi pede malesuada in imperdiet et commodo vulputate justo in blandit ultrices enim lorem ipsum dolor sit amet consectetuer adipiscing elit proin interdum mauris non ligula pellentesque ultrices phasellus id sapien in sapien iaculis congue vivamus metus arcu adipiscing molestie hendrerit at vulputate vitae nisl aenean lectus pellentesque eget nunc donec quis orci eget orci vehicula condimentum curabitur in libero ut massa volutpat convallis', 'Public Utilities', 'Agimba', '$20952.44', '505 Sunbrook Trail', 'Russia', '3/3/2019')\n" +
",(73, 'VP Quality Control', 'Part_Time', 'maecenas tristique est et tempus semper est quam pharetra magna ac consequat metus sapien ut nunc vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae mauris viverra diam vitae quam suspendisse potenti nullam porttitor lacus at turpis donec posuere metus vitae ipsum aliquam non mauris morbi non lectus aliquam sit amet diam in magna bibendum imperdiet nullam orci pede venenatis non sodales sed tincidunt eu felis fusce posuere felis sed lacus morbi sem mauris laoreet ut rhoncus aliquet pulvinar sed nisl nunc rhoncus dui vel sem sed sagittis nam congue risus semper porta volutpat quam pede lobortis ligula sit amet eleifend pede libero quis orci nullam molestie nibh in lectus', 'Transportation', 'Skynoodle', '¥93162.37', '6995 Grayhawk Place', 'Canada', '2/9/2019')\n" +
",(74, 'Data Coordiator', 'Temporary', 'pede libero quis orci nullam molestie nibh in lectus pellentesque at nulla suspendisse potenti cras in purus eu magna vulputate luctus cum sociis natoque penatibus et magnis dis parturient montes nascetur ridiculus mus vivamus vestibulum sagittis sapien cum sociis natoque penatibus et magnis dis parturient montes nascetur ridiculus mus etiam vel augue vestibulum rutrum rutrum neque aenean auctor gravida sem praesent id massa id nisl venenatis lacinia aenean sit amet justo morbi ut odio cras mi pede malesuada in imperdiet et commodo vulputate justo in blandit ultrices enim lorem ipsum dolor sit amet consectetuer adipiscing elit proin interdum mauris non ligula pellentesque ultrices phasellus id sapien in sapien', 'Public Utilities', 'Roombo', '¥81789.00', '9 Milwaukee Center', 'Russia', '9/13/2018')\n" +
",(75, 'Biostatistician I', 'Temporary', 'adipiscing molestie hendrerit at vulputate vitae nisl aenean lectus pellentesque eget nunc donec quis orci eget orci vehicula condimentum curabitur in libero ut massa volutpat convallis morbi odio odio elementum eu interdum eu tincidunt in leo maecenas pulvinar lobortis est phasellus sit amet erat nulla tempus', 'Transportation', 'Edgewire', '€99005,52', '6357 Talmadge Hill', 'Greece', '10/28/2018')\n" +
",(76, 'Mechanical Systems Engineer', 'Internship', 'lectus vestibulum quam sapien varius ut blandit non interdum in ante vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae duis faucibus accumsan odio curabitur convallis duis consequat dui nec nisi volutpat eleifend donec ut dolor morbi vel lectus in quam fringilla rhoncus mauris enim leo rhoncus sed vestibulum sit amet cursus id turpis integer aliquet massa id lobortis convallis tortor risus dapibus augue vel accumsan tellus nisi eu orci', 'Finance', 'Wikizz', '$30636.83', '26 Northport Hill', 'Spain', '4/26/2018')\n" +
",(77, 'Budget/Accounting Analyst II', 'Internship', 'congue elementum in hac habitasse platea dictumst morbi vestibulum velit id pretium iaculis diam erat fermentum justo nec condimentum neque sapien placerat ante nulla justo aliquam quis turpis eget elit sodales scelerisque mauris sit amet eros suspendisse accumsan tortor quis turpis sed ante vivamus tortor duis mattis egestas metus aenean fermentum donec ut mauris eget massa tempor convallis nulla neque libero convallis eget', 'Transportation', 'Edgeclub', '$33999.98', '72 Green Trail', 'China', '9/7/2018')\n" +
",(78, 'Automation Specialist III', 'Full_Time', 'hac habitasse platea dictumst aliquam augue quam sollicitudin vitae consectetuer eget rutrum at lorem integer tincidunt ante vel ipsum praesent blandit lacinia erat vestibulum sed magna at nunc commodo placerat praesent blandit nam nulla integer pede justo lacinia eget tincidunt eget tempus vel pede morbi porttitor lorem id ligula suspendisse ornare consequat lectus in est risus auctor sed tristique in tempus sit amet sem fusce consequat nulla nisl nunc nisl duis bibendum felis sed', 'Construction', 'Wikizz', '£85656.56', '28692 Victoria Pass', 'United States', '10/12/2018')\n" +
",(79, 'Business Systems Development Analyst', 'Temporary', 'ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae mauris viverra diam vitae quam suspendisse potenti nullam porttitor lacus at turpis donec posuere metus vitae ipsum aliquam non mauris morbi non lectus aliquam sit amet diam in magna bibendum imperdiet nullam orci pede venenatis non sodales sed tincidunt eu felis fusce posuere', 'Public Utilities', 'Edgeclub', '€23965,32', '78 Vermont Drive', 'Russia', '4/25/2018')\n" +
",(80, 'Editor', 'Full_Time', 'interdum in ante vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae duis faucibus accumsan odio curabitur convallis duis consequat dui nec nisi volutpat eleifend donec ut dolor morbi vel lectus in quam fringilla rhoncus mauris enim leo rhoncus sed', 'Construction', 'Trupe', '$38687.15', '9386 Independence Drive', 'China', '4/3/2018')\n" +
",(81, 'Help Desk Operator', 'Part_Time', 'venenatis tristique fusce congue diam id ornare imperdiet sapien urna pretium nisl ut volutpat sapien arcu sed augue aliquam erat volutpat in congue etiam justo etiam pretium iaculis justo in hac habitasse platea dictumst etiam faucibus cursus urna ut tellus nulla ut erat id mauris vulputate elementum nullam varius nulla facilisi cras non velit nec nisi vulputate nonummy', 'Construction', 'Tekfly', '$90700.82', '14 Sloan Drive', 'Philippines', '8/8/2018')\n" +
",(82, 'Structural Engineer', 'Part_Time', 'eget massa tempor convallis nulla neque libero convallis eget eleifend luctus ultricies eu nibh quisque id justo sit amet sapien dignissim vestibulum vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae nulla dapibus dolor vel est donec odio justo sollicitudin ut suscipit a feugiat et eros vestibulum', 'Public Utilities', 'Fanoodle', '€36519,77', '091 Colorado Street', 'China', '5/27/2018')\n" +
",(83, 'Human Resources Manager', 'Temporary', 'convallis duis consequat dui nec nisi volutpat eleifend donec ut dolor morbi vel lectus in quam fringilla rhoncus mauris enim leo rhoncus sed vestibulum sit amet cursus id turpis integer aliquet massa id lobortis convallis tortor risus dapibus augue vel accumsan tellus nisi eu orci mauris lacinia sapien quis libero nullam sit amet turpis elementum ligula vehicula consequat morbi a ipsum integer a nibh in', 'Public Utilities', 'Oyope', '$45663.59', '62 Ruskin Place', 'Czech Republic', '11/11/2018')\n" +
",(84, 'Senior Sales Associate', 'Permanent', 'vitae quam suspendisse potenti nullam porttitor lacus at turpis donec posuere metus vitae ipsum aliquam non mauris morbi non lectus aliquam sit amet diam in magna bibendum imperdiet nullam orci pede venenatis non sodales sed tincidunt eu felis fusce posuere felis sed lacus morbi sem mauris laoreet ut rhoncus aliquet pulvinar sed nisl nunc rhoncus dui vel sem sed sagittis nam congue risus semper porta volutpat quam pede', 'Construction', 'Photospace', '€51526,52', '4 Dapin Court', 'Malaysia', '12/23/2018')\n" +
",(85, 'Computer Systems Analyst IV', 'Temporary', 'eleifend quam a odio in hac habitasse platea dictumst maecenas ut massa quis augue luctus tincidunt nulla mollis molestie lorem quisque ut erat curabitur gravida nisi at nibh in hac habitasse platea dictumst aliquam augue quam sollicitudin vitae consectetuer eget rutrum at lorem integer tincidunt ante vel ipsum praesent blandit lacinia erat vestibulum sed magna at nunc commodo placerat praesent blandit nam nulla integer pede justo lacinia eget tincidunt eget tempus vel pede morbi porttitor lorem id ligula suspendisse ornare consequat lectus in est risus auctor sed tristique in tempus sit amet', 'Construction', 'Mydo', '£46898.06', '62 Clemons Avenue', 'Latvia', '1/28/2019')\n" +
",(86, 'Web Developer II', 'Part_Time', 'ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae nulla dapibus dolor vel est donec odio justo sollicitudin ut suscipit a feugiat et eros vestibulum ac est lacinia nisi venenatis tristique fusce congue diam id ornare imperdiet sapien urna pretium nisl ut volutpat sapien arcu sed augue aliquam erat volutpat in congue etiam justo etiam pretium iaculis justo in hac habitasse platea dictumst etiam faucibus cursus urna ut tellus nulla ut erat id mauris vulputate elementum nullam varius nulla facilisi cras non velit nec nisi vulputate nonummy maecenas tincidunt lacus at velit vivamus vel nulla eget eros elementum pellentesque quisque porta volutpat erat quisque', 'Transportation', 'Yakidoo', '$99794.68', '0184 Maple Wood Alley', 'Thailand', '10/27/2018')\n" +
",(87, 'Staff Accountant III', 'Part_Time', 'euismod scelerisque quam turpis adipiscing lorem vitae mattis nibh ligula nec sem duis aliquam convallis nunc proin at turpis a pede posuere nonummy integer non velit donec diam neque vestibulum eget vulputate ut ultrices vel augue vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae donec pharetra magna vestibulum aliquet ultrices erat tortor sollicitudin mi sit amet lobortis sapien sapien non mi integer ac neque duis bibendum morbi non quam nec dui luctus rutrum nulla tellus in sagittis dui vel nisl duis ac nibh fusce lacus purus aliquet at feugiat non pretium quis lectus suspendisse potenti in eleifend quam a odio in hac habitasse platea dictumst maecenas ut massa quis augue luctus tincidunt nulla mollis molestie lorem quisque ut', 'Consumer Services', 'Roodel', '€53750,87', '73010 Cordelia Plaza', 'South Africa', '3/1/2019')\n" +
",(88, 'Senior Quality Engineer', 'Full_Time', 'ut nunc vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae mauris viverra diam vitae quam suspendisse potenti nullam porttitor lacus at turpis donec posuere metus vitae ipsum aliquam non mauris morbi non lectus aliquam sit amet diam in magna bibendum imperdiet nullam orci pede venenatis non sodales sed tincidunt eu felis fusce posuere felis sed lacus morbi sem mauris laoreet ut rhoncus aliquet pulvinar sed nisl nunc rhoncus dui vel sem sed sagittis nam congue risus semper porta volutpat quam pede lobortis ligula sit amet eleifend pede libero quis orci nullam molestie nibh in lectus pellentesque at nulla suspendisse potenti cras in', 'Finance', 'Zoombox', '£67946.00', '186 Melby Point', 'Tonga', '4/6/2018')\n" +
",(89, 'Tax Accountant', 'Permanent', 'at nibh in hac habitasse platea dictumst aliquam augue quam sollicitudin vitae consectetuer eget rutrum at lorem integer tincidunt ante vel ipsum praesent blandit lacinia erat vestibulum sed magna at nunc commodo placerat praesent blandit nam nulla integer pede justo lacinia eget tincidunt eget tempus vel pede morbi porttitor lorem id ligula suspendisse ornare consequat lectus in est risus auctor sed tristique in tempus sit amet sem fusce consequat nulla nisl nunc nisl duis bibendum felis sed interdum venenatis turpis enim blandit mi in porttitor pede justo eu massa donec dapibus duis at velit eu est congue elementum in hac habitasse platea dictumst morbi vestibulum velit id pretium iaculis diam', 'Consumer Services', 'Tavu', '¥29407.45', '8524 Nancy Place', 'Philippines', '5/7/2018')\n" +
",(90, 'Project Manager', 'Permanent', 'in hac habitasse platea dictumst aliquam augue quam sollicitudin vitae consectetuer eget rutrum at lorem integer tincidunt ante vel ipsum praesent blandit lacinia erat vestibulum sed magna at nunc commodo placerat praesent blandit nam nulla integer pede justo lacinia eget tincidunt eget tempus vel pede morbi porttitor lorem id ligula suspendisse ornare consequat lectus in est risus auctor sed tristique in tempus sit amet sem fusce consequat nulla nisl nunc nisl duis bibendum felis sed interdum venenatis turpis enim blandit mi in porttitor pede justo eu massa donec dapibus duis at velit', 'Construction', 'Meembee', '$32650.74', '30 Hansons Junction', 'Portugal', '9/5/2018')");
        String populate2 = ("insert into JOBS (JOB_ID, JOB_TITLE, JOB_TYPE, JOB_DESCRIPTION, SECTOR, COMPANY_NAME, SALARY, ADDRESS, COUNTRY, APPLY_BY_DATE) values (91, 'VP Sales', 'Full_Time', 'leo odio porttitor id consequat in consequat ut nulla sed accumsan felis ut at dolor quis odio consequat varius integer ac leo pellentesque ultrices mattis odio donec vitae nisi nam ultrices libero non mattis pulvinar nulla pede ullamcorper augue a suscipit nulla elit ac nulla sed vel enim sit amet nunc viverra dapibus nulla suscipit', 'Transportation', 'Photobug', '€58650,06', '03 New Castle Crossing', 'China', '7/1/2018')\n" +
",(92, 'Design Engineer', 'Internship', 'neque vestibulum eget vulputate ut ultrices vel augue vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae donec pharetra magna vestibulum aliquet ultrices erat tortor sollicitudin mi sit amet lobortis sapien sapien non mi integer ac neque duis bibendum morbi non quam nec dui luctus rutrum nulla tellus in sagittis dui vel nisl duis ac nibh fusce lacus purus aliquet at feugiat non pretium quis lectus suspendisse potenti in eleifend quam a odio in hac habitasse platea dictumst maecenas ut massa quis augue luctus tincidunt nulla mollis molestie lorem quisque ut erat curabitur gravida nisi at nibh in hac habitasse platea dictumst aliquam augue quam sollicitudin vitae consectetuer eget rutrum at lorem integer tincidunt ante vel ipsum praesent blandit', 'Construction', 'Realpoint', '€44123,06', '09 Northland Point', 'China', '11/15/2018')\n" +
",(93, 'Senior Financial Analyst', 'Temporary', 'mauris viverra diam vitae quam suspendisse potenti nullam porttitor lacus at turpis donec posuere metus vitae ipsum aliquam non mauris morbi non lectus aliquam sit amet diam in magna bibendum imperdiet nullam orci pede venenatis non sodales sed tincidunt eu felis fusce posuere felis sed lacus morbi sem mauris laoreet ut rhoncus aliquet pulvinar sed nisl nunc rhoncus dui vel sem sed sagittis nam congue risus semper porta volutpat quam pede lobortis ligula sit amet eleifend pede libero quis orci nullam molestie nibh in lectus', 'Public Utilities', 'Dabshots', '€71445,81', '53 Forster Avenue', 'France', '9/14/2018')\n" +
",(94, 'Social Worker', 'Internship', 'lectus in est risus auctor sed tristique in tempus sit amet sem fusce consequat nulla nisl nunc nisl duis bibendum felis sed interdum venenatis turpis enim blandit mi in porttitor pede justo eu massa donec dapibus duis at velit eu est congue elementum in hac habitasse platea dictumst morbi vestibulum velit id pretium iaculis diam erat fermentum justo nec condimentum neque sapien placerat ante nulla justo aliquam quis turpis eget elit sodales scelerisque mauris sit amet eros suspendisse accumsan tortor quis turpis sed ante vivamus tortor duis mattis', 'Finance', 'Wordpedia', '$50605.66', '6 Sachtjen Trail', 'Nigeria', '9/20/2018')\n" +
",(95, 'Budget/Accounting Analyst IV', 'Temporary', 'nec sem duis aliquam convallis nunc proin at turpis a pede posuere nonummy integer non velit donec diam neque vestibulum eget vulputate ut ultrices vel augue vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae donec pharetra magna vestibulum aliquet ultrices erat tortor sollicitudin mi sit amet lobortis sapien sapien non mi integer ac neque duis bibendum morbi non quam nec dui luctus rutrum nulla tellus in sagittis dui vel nisl duis ac nibh', 'Basic Industries', 'Devify', '$34868.25', '1617 Northport Circle', 'Pitcairn', '7/21/2018')\n" +
",(96, 'Technical Writer', 'Part_Time', 'curae duis faucibus accumsan odio curabitur convallis duis consequat dui nec nisi volutpat eleifend donec ut dolor morbi vel lectus in quam fringilla rhoncus mauris enim leo rhoncus sed vestibulum sit amet cursus id turpis integer aliquet massa id lobortis convallis tortor', 'Finance', 'Yotz', '¥85931.56', '40 Dixon Street', 'Poland', '8/27/2018')\n" +
",(97, 'Dental Hygienist', 'Part_Time', 'in sapien iaculis congue vivamus metus arcu adipiscing molestie hendrerit at vulputate vitae nisl aenean lectus pellentesque eget nunc donec quis orci eget orci vehicula condimentum curabitur in libero ut massa volutpat convallis morbi odio odio elementum eu interdum eu tincidunt in leo maecenas pulvinar lobortis est phasellus sit amet erat nulla tempus vivamus in felis eu sapien cursus vestibulum proin eu mi nulla ac enim in tempor turpis nec euismod scelerisque quam turpis adipiscing lorem vitae mattis nibh ligula nec', 'Public Utilities', 'Photojam', '€40575,49', '69239 Banding Pass', 'Afghanistan', '12/2/2018')\n" +
",(98, 'Tax Accountant', 'Temporary', 'eros viverra eget congue eget semper rutrum nulla nunc purus phasellus in felis donec semper sapien a libero nam dui proin leo odio porttitor id consequat in consequat ut nulla sed accumsan felis ut at dolor quis odio consequat varius integer ac', 'Construction', 'Pixope', '$97476.37', '2098 Muir Plaza', 'Tajikistan', '2/5/2019')\n" +
",(99, 'Clinical Specialist', 'Permanent', 'dapibus augue vel accumsan tellus nisi eu orci mauris lacinia sapien quis libero nullam sit amet turpis elementum ligula vehicula consequat morbi a ipsum integer a nibh in quis justo maecenas rhoncus aliquam lacus morbi quis tortor id nulla ultrices aliquet maecenas leo odio condimentum id luctus nec molestie sed justo pellentesque viverra pede ac diam cras pellentesque volutpat dui maecenas tristique est et tempus semper est quam pharetra magna ac consequat metus sapien ut nunc vestibulum ante ipsum primis in faucibus orci luctus et', 'Finance', 'Gigabox', '$21910.07', '2436 Eastwood Park', 'Albania', '1/6/2019')\n" +
",(100, 'Recruiting Manager', 'Internship', 'massa volutpat convallis morbi odio odio elementum eu interdum eu tincidunt in leo maecenas pulvinar lobortis est phasellus sit amet erat nulla tempus vivamus in felis eu sapien cursus vestibulum proin eu mi nulla ac enim in tempor turpis nec euismod scelerisque quam turpis adipiscing lorem vitae mattis nibh ligula nec sem duis aliquam convallis nunc proin at turpis a pede posuere nonummy integer non velit donec diam neque vestibulum eget vulputate ut ultrices vel augue vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae donec pharetra magna vestibulum aliquet ultrices erat tortor sollicitudin mi sit amet lobortis sapien sapien non mi integer ac neque duis bibendum morbi non quam nec dui luctus rutrum nulla tellus in', 'Public Utilities', 'Photofeed', '€38011,76', '303 Sugar Junction', 'South Africa', '5/5/2018')\n" +
",(101, 'Civil Engineer', 'Part_Time', 'tincidunt eget tempus vel pede morbi porttitor lorem id ligula suspendisse ornare consequat lectus in est risus auctor sed tristique in tempus sit amet sem fusce consequat nulla nisl nunc nisl duis bibendum felis sed interdum venenatis turpis enim blandit mi in porttitor pede justo eu massa donec dapibus duis at velit eu est congue elementum in hac habitasse platea dictumst morbi vestibulum velit id pretium iaculis diam erat fermentum justo nec condimentum neque sapien placerat ante nulla justo aliquam', 'Consumer Services', 'Kayveo', '€51784,84', '29 Ridgeway Lane', 'Poland', '9/25/2018')\n" +
",(102, 'Developer II', 'Internship', 'accumsan tellus nisi eu orci mauris lacinia sapien quis libero nullam sit amet turpis elementum ligula vehicula consequat morbi a ipsum integer a nibh in quis justo maecenas rhoncus aliquam lacus morbi quis tortor id nulla ultrices aliquet maecenas leo odio condimentum id luctus nec molestie sed justo pellentesque viverra pede ac diam cras pellentesque volutpat dui maecenas tristique est et tempus semper est quam pharetra magna ac consequat metus sapien ut nunc', 'Finance', 'Jaxbean', '¥23126.07', '332 Canary Alley', 'China', '5/22/2018')\n" +
",(103, 'General Manager', 'Permanent', 'praesent blandit lacinia erat vestibulum sed magna at nunc commodo placerat praesent blandit nam nulla integer pede justo lacinia eget tincidunt eget tempus vel pede morbi porttitor lorem id ligula suspendisse ornare consequat lectus in est risus auctor sed tristique in tempus sit amet sem fusce consequat nulla nisl nunc nisl duis bibendum felis sed interdum venenatis turpis enim blandit mi in porttitor pede justo eu massa donec dapibus duis at velit eu est congue elementum', 'Finance', 'Yamia', '$80504.33', '23421 Thackeray Drive', 'Indonesia', '5/16/2018')\n" +
",(104, 'Executive Secretary', 'Internship', 'in felis eu sapien cursus vestibulum proin eu mi nulla ac enim in tempor turpis nec euismod scelerisque quam turpis adipiscing lorem vitae mattis nibh ligula nec sem duis aliquam convallis nunc proin at turpis a pede posuere nonummy integer non velit donec diam neque vestibulum eget vulputate ut ultrices vel augue vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae donec pharetra magna vestibulum aliquet ultrices erat tortor sollicitudin mi sit amet lobortis sapien sapien non mi integer ac neque duis bibendum morbi non quam nec dui luctus rutrum nulla tellus in sagittis dui vel nisl duis ac', 'Public Utilities', 'Voonder', '€87166,86', '30 Marcy Trail', 'Indonesia', '11/12/2018')\n" +
",(105, 'Chemical Engineer', 'Part_Time', 'suscipit a feugiat et eros vestibulum ac est lacinia nisi venenatis tristique fusce congue diam id ornare imperdiet sapien urna pretium nisl ut volutpat sapien arcu sed augue aliquam erat volutpat in congue etiam justo etiam pretium iaculis justo in hac habitasse platea dictumst etiam faucibus cursus urna ut tellus nulla ut erat id mauris vulputate elementum nullam varius nulla facilisi cras non velit nec nisi vulputate nonummy maecenas tincidunt lacus at velit vivamus vel nulla eget eros elementum pellentesque quisque porta volutpat erat quisque erat eros viverra eget congue', 'Construction', 'Roomm', '£89700.88', '08439 Schmedeman Alley', 'Philippines', '8/9/2018')\n" +
",(106, 'Geologist III', 'Temporary', 'sit amet consectetuer adipiscing elit proin risus praesent lectus vestibulum quam sapien varius ut blandit non interdum in ante vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae duis faucibus accumsan odio curabitur convallis duis consequat dui nec nisi volutpat eleifend donec ut dolor morbi vel lectus in', 'Construction', 'Divanoodle', '€31523,72', '00314 Cambridge Junction', 'Guatemala', '4/19/2018')\n" +
",(107, 'Social Worker', 'Part_Time', 'eleifend donec ut dolor morbi vel lectus in quam fringilla rhoncus mauris enim leo rhoncus sed vestibulum sit amet cursus id turpis integer aliquet massa id lobortis convallis tortor risus dapibus augue vel accumsan tellus nisi eu orci mauris lacinia sapien quis libero nullam sit amet turpis elementum ligula vehicula consequat morbi', 'Consumer Services', 'Yodoo', '£99398.94', '9948 Mallory Avenue', 'China', '8/24/2018')\n" +
",(108, 'Product Engineer', 'Temporary', 'quam nec dui luctus rutrum nulla tellus in sagittis dui vel nisl duis ac nibh fusce lacus purus aliquet at feugiat non pretium quis lectus suspendisse potenti in eleifend quam a odio in hac habitasse platea dictumst maecenas ut massa quis augue luctus tincidunt nulla mollis molestie lorem quisque ut erat curabitur gravida nisi at nibh in hac habitasse platea', 'Construction', 'Zoovu', '£27748.39', '02653 Fairfield Hill', 'Portugal', '8/28/2018')\n" +
",(109, 'Chief Design Engineer', 'Temporary', 'id lobortis convallis tortor risus dapibus augue vel accumsan tellus nisi eu orci mauris lacinia sapien quis libero nullam sit amet turpis elementum ligula vehicula consequat morbi a ipsum integer a nibh in quis justo maecenas rhoncus aliquam lacus morbi quis tortor id nulla ultrices aliquet maecenas leo odio condimentum id luctus nec molestie sed justo pellentesque viverra pede ac diam cras pellentesque volutpat dui maecenas tristique est et tempus semper est quam pharetra', 'Finance', 'Youspan', '$39151.73', '18 Village Green Center', 'Indonesia', '10/13/2018')\n" +
",(110, 'Accounting Assistant I', 'Part_Time', 'magnis dis parturient montes nascetur ridiculus mus vivamus vestibulum sagittis sapien cum sociis natoque penatibus et magnis dis parturient montes nascetur ridiculus mus etiam vel augue vestibulum rutrum rutrum neque aenean auctor gravida sem praesent id massa id nisl venenatis lacinia aenean sit amet justo morbi ut odio cras mi pede malesuada in imperdiet et commodo vulputate justo in blandit ultrices enim lorem ipsum dolor sit amet consectetuer adipiscing elit proin interdum mauris non ligula pellentesque ultrices phasellus id sapien', 'Public Utilities', 'Dabshots', '£33413.20', '6264 Trailsway Terrace', 'Cuba', '11/6/2018')\n" +
",(111, 'Social Worker', 'Permanent', 'sit amet eleifend pede libero quis orci nullam molestie nibh in lectus pellentesque at nulla suspendisse potenti cras in purus eu magna vulputate luctus cum sociis natoque penatibus et magnis dis parturient montes nascetur ridiculus mus vivamus vestibulum sagittis sapien cum sociis natoque penatibus et magnis dis parturient montes nascetur ridiculus mus etiam vel augue vestibulum rutrum rutrum neque aenean auctor gravida sem praesent id massa id nisl venenatis lacinia aenean sit amet justo morbi ut odio cras mi pede malesuada in imperdiet et commodo vulputate justo in blandit ultrices enim lorem ipsum dolor sit amet consectetuer adipiscing elit proin interdum mauris non ligula pellentesque ultrices phasellus id sapien in sapien iaculis congue vivamus metus arcu adipiscing molestie hendrerit at vulputate vitae nisl', 'Construction', 'Browsetype', '¥53570.31', '44 Sheridan Point', 'Yemen', '5/11/2018')\n" +
",(112, 'Human Resources Manager', 'Internship', 'tortor risus dapibus augue vel accumsan tellus nisi eu orci mauris lacinia sapien quis libero nullam sit amet turpis elementum ligula vehicula consequat morbi a ipsum integer a nibh in quis justo maecenas rhoncus aliquam lacus morbi quis tortor id', 'Transportation', 'Vinder', '£75271.23', '53 Thierer Crossing', 'Brazil', '10/24/2018')\n" +
",(113, 'Senior Quality Engineer', 'Internship', 'orci pede venenatis non sodales sed tincidunt eu felis fusce posuere felis sed lacus morbi sem mauris laoreet ut rhoncus aliquet pulvinar sed nisl nunc rhoncus dui vel sem sed sagittis nam congue risus semper porta volutpat quam pede lobortis ligula sit amet eleifend pede libero quis orci nullam molestie nibh in lectus pellentesque at nulla suspendisse potenti cras in purus eu magna vulputate luctus cum sociis natoque penatibus et magnis dis parturient montes nascetur ridiculus mus vivamus vestibulum sagittis sapien cum sociis natoque penatibus et magnis dis parturient montes nascetur ridiculus mus etiam vel augue vestibulum rutrum rutrum neque aenean auctor gravida sem praesent', 'Construction', 'Tagpad', '$87443.51', '79314 Prentice Place', 'Canada', '1/10/2019')\n" +
",(114, 'Statistician II', 'Full_Time', 'fusce congue diam id ornare imperdiet sapien urna pretium nisl ut volutpat sapien arcu sed augue aliquam erat volutpat in congue etiam justo etiam pretium iaculis justo in hac habitasse platea dictumst etiam faucibus cursus urna ut tellus nulla ut erat id mauris vulputate elementum nullam varius nulla facilisi cras non velit nec nisi vulputate nonummy maecenas tincidunt lacus at velit vivamus vel nulla eget eros elementum pellentesque quisque porta volutpat erat quisque erat eros viverra eget congue eget semper rutrum nulla nunc purus phasellus in felis donec semper sapien a libero nam dui proin leo odio porttitor id consequat in consequat ut nulla sed accumsan felis ut at dolor quis odio consequat varius', 'Public Utilities', 'Trudeo', '€97443,84', '844 Cherokee Park', 'Belarus', '5/9/2018')\n" +
",(115, 'Developer IV', 'Full_Time', 'bibendum morbi non quam nec dui luctus rutrum nulla tellus in sagittis dui vel nisl duis ac nibh fusce lacus purus aliquet at feugiat non pretium quis lectus suspendisse potenti in eleifend quam a odio in hac habitasse platea dictumst maecenas ut massa quis augue luctus tincidunt nulla mollis molestie lorem quisque ut erat curabitur gravida nisi at nibh in hac habitasse platea dictumst aliquam augue quam sollicitudin vitae consectetuer eget rutrum at lorem integer tincidunt ante vel ipsum praesent blandit lacinia erat vestibulum sed magna at nunc commodo placerat praesent blandit nam nulla integer pede justo lacinia eget tincidunt eget tempus vel pede morbi porttitor lorem id ligula suspendisse ornare consequat lectus in est risus auctor sed tristique in tempus sit amet', 'Transportation', 'Eayo', '£56238.22', '7503 Dorton Terrace', 'Poland', '6/18/2018')\n" +
",(116, 'Administrative Assistant I', 'Temporary', 'aliquam convallis nunc proin at turpis a pede posuere nonummy integer non velit donec diam neque vestibulum eget vulputate ut ultrices vel augue vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae donec pharetra magna vestibulum aliquet ultrices erat tortor sollicitudin mi sit amet lobortis sapien sapien non mi integer ac neque', 'Basic Industries', 'Gigaclub', '$89275.63', '047 Duke Center', 'Brazil', '10/3/2018')\n" +
",(117, 'Pharmacist', 'Internship', 'ultrices posuere cubilia curae mauris viverra diam vitae quam suspendisse potenti nullam porttitor lacus at turpis donec posuere metus vitae ipsum aliquam non mauris morbi non lectus aliquam sit amet diam in magna bibendum imperdiet nullam orci pede venenatis non sodales sed tincidunt eu felis fusce posuere felis sed lacus morbi sem mauris laoreet ut rhoncus aliquet pulvinar sed nisl nunc rhoncus dui vel sem sed sagittis nam congue risus semper porta volutpat quam pede lobortis ligula sit amet eleifend pede libero quis orci nullam molestie nibh in lectus pellentesque at nulla suspendisse', 'Finance', 'Jabbersphere', '$66085.97', '79 Spohn Street', 'Greece', '9/9/2018')\n" +
",(118, 'Structural Engineer', 'Temporary', 'fusce lacus purus aliquet at feugiat non pretium quis lectus suspendisse potenti in eleifend quam a odio in hac habitasse platea dictumst maecenas ut massa quis augue luctus tincidunt nulla mollis molestie lorem quisque ut erat curabitur gravida nisi at nibh in hac habitasse platea dictumst aliquam augue quam sollicitudin vitae consectetuer eget rutrum at lorem integer tincidunt ante vel ipsum praesent blandit lacinia erat vestibulum sed magna at nunc commodo placerat praesent blandit nam nulla integer pede justo lacinia eget tincidunt eget tempus vel pede morbi porttitor lorem id ligula suspendisse ornare consequat lectus in est risus auctor sed tristique', 'Construction', 'Leexo', '£31338.23', '88 Fuller Lane', 'China', '3/23/2018')\n" +
",(119, 'General Manager', 'Full_Time', 'pellentesque ultrices phasellus id sapien in sapien iaculis congue vivamus metus arcu adipiscing molestie hendrerit at vulputate vitae nisl aenean lectus pellentesque eget nunc donec quis orci eget orci vehicula condimentum curabitur in libero ut massa volutpat convallis morbi odio odio elementum eu interdum eu tincidunt in leo maecenas pulvinar lobortis est phasellus sit amet erat nulla tempus vivamus in felis eu sapien cursus vestibulum proin eu mi nulla ac enim in tempor turpis nec euismod scelerisque quam turpis adipiscing lorem vitae', 'Construction', 'Aibox', '$49024.65', '0 Main Avenue', 'China', '4/9/2018')\n" +
",(120, 'Compensation Analyst', 'Part_Time', 'nisl ut volutpat sapien arcu sed augue aliquam erat volutpat in congue etiam justo etiam pretium iaculis justo in hac habitasse platea dictumst etiam faucibus cursus urna ut tellus nulla ut erat id mauris vulputate elementum nullam varius nulla facilisi cras non velit nec nisi vulputate nonummy maecenas tincidunt lacus', 'Finance', 'Riffpedia', '$36945.91', '4417 Moulton Pass', 'Peru', '8/7/2018')\n" +
",(121, 'Information Systems Manager', 'Part_Time', 'platea dictumst maecenas ut massa quis augue luctus tincidunt nulla mollis molestie lorem quisque ut erat curabitur gravida nisi at nibh in hac habitasse platea dictumst aliquam augue quam sollicitudin vitae consectetuer eget rutrum at lorem integer tincidunt ante vel ipsum praesent blandit lacinia erat vestibulum sed magna at nunc commodo placerat praesent blandit nam nulla integer pede justo lacinia eget tincidunt eget', 'Consumer Services', 'Layo', '£32433.41', '39 2nd Lane', 'China', '6/6/2018')\n" +
",(122, 'Software Engineer III', 'Full_Time', 'sapien non mi integer ac neque duis bibendum morbi non quam nec dui luctus rutrum nulla tellus in sagittis dui vel nisl duis ac nibh fusce lacus purus aliquet at feugiat non pretium quis lectus suspendisse potenti in eleifend quam a odio in hac habitasse platea dictumst maecenas ut massa quis augue luctus tincidunt nulla mollis molestie lorem quisque ut erat curabitur gravida nisi at nibh in hac habitasse platea dictumst aliquam augue quam sollicitudin vitae consectetuer eget rutrum at lorem integer tincidunt ante vel ipsum praesent blandit lacinia erat vestibulum sed magna at nunc commodo placerat praesent blandit nam nulla integer pede justo lacinia eget tincidunt eget', 'Transportation', 'Jabberstorm', '$20075.05', '85628 Ridgeway Place', 'China', '7/3/2018')\n" +
",(123, 'Business Systems Development Analyst', 'Temporary', 'pellentesque viverra pede ac diam cras pellentesque volutpat dui maecenas tristique est et tempus semper est quam pharetra magna ac consequat metus sapien ut nunc vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae mauris viverra diam vitae quam suspendisse potenti nullam porttitor lacus at turpis donec posuere metus', 'Finance', 'Leenti', '€50456,44', '320 Vera Road', 'Yemen', '10/15/2018')\n" +
",(124, 'Assistant Media Planner', 'Part_Time', 'consequat nulla nisl nunc nisl duis bibendum felis sed interdum venenatis turpis enim blandit mi in porttitor pede justo eu massa donec dapibus duis at velit eu est congue elementum in hac habitasse platea dictumst morbi vestibulum velit id pretium iaculis diam erat fermentum justo nec condimentum neque sapien placerat ante nulla justo aliquam quis turpis eget elit sodales scelerisque mauris sit amet eros suspendisse accumsan tortor', 'Transportation', 'Photospace', '¥21447.51', '8 Transport Point', 'Greece', '12/6/2018')\n" +
",(125, 'Senior Financial Analyst', 'Temporary', 'venenatis tristique fusce congue diam id ornare imperdiet sapien urna pretium nisl ut volutpat sapien arcu sed augue aliquam erat volutpat in congue etiam justo etiam pretium iaculis justo in hac habitasse platea dictumst etiam faucibus cursus urna ut tellus nulla ut erat id mauris vulputate elementum nullam varius nulla facilisi cras non velit nec nisi vulputate nonummy maecenas tincidunt lacus at velit vivamus vel nulla eget eros elementum pellentesque quisque porta volutpat erat quisque erat eros viverra eget congue eget semper rutrum nulla nunc purus phasellus in felis donec semper sapien a libero nam dui proin', 'Consumer Services', 'Linkbridge', '$58388.08', '2 Graedel Pass', 'Indonesia', '11/8/2018')\n" +
",(126, 'Financial Analyst', 'Part_Time', 'pellentesque ultrices phasellus id sapien in sapien iaculis congue vivamus metus arcu adipiscing molestie hendrerit at vulputate vitae nisl aenean lectus pellentesque eget nunc donec quis orci eget orci vehicula condimentum curabitur in libero ut massa volutpat convallis morbi odio odio elementum eu interdum eu tincidunt in leo maecenas pulvinar lobortis est phasellus sit amet erat nulla tempus vivamus in felis eu sapien cursus vestibulum', 'Consumer Services', 'Twiyo', '€33386,78', '43421 Oak Valley Park', 'Russia', '7/20/2018')\n" +
",(127, 'Occupational Therapist', 'Full_Time', 'aliquam convallis nunc proin at turpis a pede posuere nonummy integer non velit donec diam neque vestibulum eget vulputate ut ultrices vel augue vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae donec pharetra magna vestibulum aliquet ultrices erat tortor sollicitudin mi sit amet lobortis sapien sapien non mi integer ac neque duis bibendum morbi non quam nec dui luctus rutrum nulla tellus in sagittis dui vel nisl duis ac nibh fusce', 'Public Utilities', 'Thoughtblab', '¥25078.26', '74213 6th Drive', 'Mauritius', '10/17/2018')\n" +
",(128, 'Research Associate', 'Full_Time', 'justo etiam pretium iaculis justo in hac habitasse platea dictumst etiam faucibus cursus urna ut tellus nulla ut erat id mauris vulputate elementum nullam varius nulla facilisi cras non velit nec nisi vulputate nonummy maecenas tincidunt lacus at velit vivamus vel nulla eget eros elementum pellentesque quisque porta volutpat erat', 'Transportation', 'Cogilith', '¥82033.54', '0 Loeprich Place', 'Brazil', '9/23/2018')\n" +
",(129, 'Food Chemist', 'Temporary', 'vulputate vitae nisl aenean lectus pellentesque eget nunc donec quis orci eget orci vehicula condimentum curabitur in libero ut massa volutpat convallis morbi odio odio elementum eu interdum eu tincidunt in leo maecenas pulvinar lobortis est phasellus sit amet erat nulla tempus vivamus in felis eu sapien cursus vestibulum proin eu mi nulla ac enim in tempor turpis nec euismod scelerisque quam turpis adipiscing lorem vitae mattis nibh ligula nec sem duis aliquam convallis nunc proin at turpis a pede', 'Basic Industries', 'Youspan', '$65420.10', '64525 Dryden Alley', 'China', '3/17/2018')\n" +
",(130, 'Professor', 'Temporary', 'libero convallis eget eleifend luctus ultricies eu nibh quisque id justo sit amet sapien dignissim vestibulum vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae nulla dapibus dolor vel est donec odio justo sollicitudin ut suscipit a feugiat et eros vestibulum ac est lacinia nisi venenatis tristique fusce', 'Construction', 'Photospace', '$94966.20', '8 Rigney Circle', 'Thailand', '3/2/2019')\n" +
",(131, 'Electrical Engineer', 'Internship', 'integer ac neque duis bibendum morbi non quam nec dui luctus rutrum nulla tellus in sagittis dui vel nisl duis ac nibh fusce lacus purus aliquet at feugiat non pretium quis lectus suspendisse potenti in eleifend quam a odio in hac habitasse platea dictumst maecenas ut massa quis augue luctus tincidunt nulla mollis molestie lorem quisque ut erat curabitur gravida nisi at nibh in hac habitasse platea dictumst aliquam augue quam sollicitudin vitae consectetuer eget rutrum at lorem integer tincidunt ante vel ipsum praesent blandit lacinia erat vestibulum sed magna at nunc commodo placerat praesent blandit nam nulla integer pede justo lacinia eget tincidunt eget tempus vel pede', 'Consumer Services', 'Thoughtworks', '£39922.64', '3 Monument Court', 'France', '12/16/2018')\n" +
",(132, 'Marketing Manager', 'Internship', 'sapien dignissim vestibulum vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae nulla dapibus dolor vel est donec odio justo sollicitudin ut suscipit a feugiat et eros vestibulum ac est lacinia nisi venenatis tristique fusce congue diam id ornare imperdiet sapien urna pretium nisl ut volutpat sapien arcu sed augue aliquam erat volutpat in congue etiam justo etiam pretium iaculis justo in hac habitasse platea dictumst etiam faucibus cursus urna ut tellus nulla ut erat id mauris vulputate elementum nullam varius nulla facilisi cras non velit nec nisi vulputate nonummy maecenas tincidunt lacus at velit vivamus vel nulla eget eros elementum pellentesque quisque porta volutpat erat quisque erat eros viverra eget congue eget semper rutrum nulla', 'Finance', 'Gabvine', '€21358,52', '2 Mifflin Terrace', 'China', '11/1/2018')\n" +
",(133, 'Project Manager', 'Internship', 'in tempus sit amet sem fusce consequat nulla nisl nunc nisl duis bibendum felis sed interdum venenatis turpis enim blandit mi in porttitor pede justo eu massa donec dapibus duis at velit eu est congue elementum in hac habitasse platea dictumst morbi vestibulum velit id pretium iaculis diam erat fermentum justo nec condimentum neque sapien placerat ante nulla justo aliquam quis turpis eget elit sodales scelerisque mauris sit amet eros suspendisse accumsan tortor quis turpis sed ante vivamus tortor duis mattis egestas metus aenean fermentum donec ut mauris eget massa tempor convallis nulla neque libero', 'Public Utilities', 'Talane', '¥99778.31', '647 Elmside Road', 'Liberia', '12/10/2018')\n" +
",(134, 'Dental Hygienist', 'Part_Time', 'orci luctus et ultrices posuere cubilia curae nulla dapibus dolor vel est donec odio justo sollicitudin ut suscipit a feugiat et eros vestibulum ac est lacinia nisi venenatis tristique fusce congue diam id ornare imperdiet sapien urna pretium nisl ut volutpat sapien arcu sed augue aliquam erat volutpat in congue etiam justo etiam pretium iaculis justo in hac habitasse platea dictumst etiam faucibus cursus urna ut tellus nulla ut erat id mauris vulputate elementum nullam varius nulla facilisi cras non velit nec nisi vulputate nonummy maecenas tincidunt lacus at velit vivamus vel nulla eget eros elementum pellentesque quisque porta volutpat erat quisque erat eros viverra eget congue eget semper rutrum nulla nunc purus phasellus in felis donec semper sapien a', 'Public Utilities', 'Kayveo', '€35633,83', '872 Evergreen Junction', 'Russia', '8/9/2018')\n" +
",(135, 'Technical Writer', 'Permanent', 'ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae mauris viverra diam vitae quam suspendisse potenti nullam porttitor lacus at turpis donec posuere metus vitae ipsum aliquam non mauris morbi non lectus aliquam sit amet diam in magna bibendum imperdiet nullam orci pede venenatis non sodales sed tincidunt eu felis fusce posuere felis sed lacus morbi sem mauris laoreet ut rhoncus aliquet pulvinar sed nisl nunc rhoncus dui vel sem sed sagittis nam congue risus semper porta volutpat quam pede lobortis ligula sit amet eleifend pede libero quis orci nullam molestie nibh in lectus pellentesque at nulla suspendisse potenti cras in purus eu magna vulputate luctus cum', 'Construction', 'Zoonder', '€67483,88', '268 Maryland Place', 'Portugal', '11/19/2018')\n" +
",(136, 'Automation Specialist II', 'Temporary', 'vulputate elementum nullam varius nulla facilisi cras non velit nec nisi vulputate nonummy maecenas tincidunt lacus at velit vivamus vel nulla eget eros elementum pellentesque quisque porta volutpat erat quisque erat eros viverra eget congue eget semper rutrum nulla nunc purus phasellus in felis donec semper sapien a libero nam dui proin leo odio porttitor id consequat in consequat ut nulla sed accumsan felis ut at dolor quis odio consequat varius integer ac leo pellentesque ultrices mattis odio donec vitae nisi nam ultrices libero non mattis pulvinar nulla pede ullamcorper augue a suscipit', 'Transportation', 'Photobean', '$43999.71', '62453 Waubesa Drive', 'Central African Republic', '7/10/2018')\n" +
",(137, 'Staff Scientist', 'Permanent', 'justo sollicitudin ut suscipit a feugiat et eros vestibulum ac est lacinia nisi venenatis tristique fusce congue diam id ornare imperdiet sapien urna pretium nisl ut volutpat sapien arcu sed augue aliquam erat volutpat in congue etiam justo etiam pretium iaculis justo in hac habitasse platea dictumst etiam faucibus cursus urna ut tellus nulla ut erat id mauris vulputate elementum nullam varius nulla facilisi cras non velit nec nisi vulputate nonummy maecenas tincidunt lacus at velit vivamus vel nulla eget eros elementum pellentesque quisque porta volutpat erat quisque erat eros viverra eget congue eget semper rutrum nulla nunc purus phasellus in felis donec semper sapien a libero nam dui proin leo odio porttitor id consequat in consequat ut nulla sed', 'Consumer Services', 'Zoomcast', '$38797.74', '9 Sugar Avenue', 'China', '12/4/2018')\n" +
",(138, 'General Manager', 'Temporary', 'in faucibus orci luctus et ultrices posuere cubilia curae duis faucibus accumsan odio curabitur convallis duis consequat dui nec nisi volutpat eleifend donec ut dolor morbi vel lectus in quam fringilla rhoncus mauris enim leo rhoncus sed vestibulum sit amet cursus id turpis integer aliquet massa id lobortis', 'Public Utilities', 'Edgepulse', '$45988.51', '24808 Prairieview Drive', 'Italy', '4/7/2018')\n" +
",(139, 'Actuary', 'Full_Time', 'arcu adipiscing molestie hendrerit at vulputate vitae nisl aenean lectus pellentesque eget nunc donec quis orci eget orci vehicula condimentum curabitur in libero ut massa volutpat convallis morbi odio odio elementum eu interdum eu tincidunt in leo maecenas pulvinar lobortis est phasellus sit amet erat nulla tempus vivamus in felis eu sapien cursus vestibulum proin eu mi nulla ac enim in tempor turpis nec euismod scelerisque quam turpis adipiscing lorem vitae mattis nibh ligula nec sem duis aliquam convallis nunc proin at turpis a pede posuere nonummy integer non velit donec diam neque', 'Public Utilities', 'Snaptags', '$87314.08', '8991 Dryden Trail', 'Russia', '4/30/2018')\n" +
",(140, 'Teacher', 'Permanent', 'interdum eu tincidunt in leo maecenas pulvinar lobortis est phasellus sit amet erat nulla tempus vivamus in felis eu sapien cursus vestibulum proin eu mi nulla ac enim in tempor turpis nec euismod scelerisque quam turpis adipiscing lorem vitae mattis nibh ligula', 'Public Utilities', 'Rhycero', '$97504.53', '547 Hovde Plaza', 'China', '5/13/2018')\n" +
",(141, 'Environmental Tech', 'Full_Time', 'sapien cum sociis natoque penatibus et magnis dis parturient montes nascetur ridiculus mus etiam vel augue vestibulum rutrum rutrum neque aenean auctor gravida sem praesent id massa id nisl venenatis lacinia aenean sit amet justo morbi ut odio cras mi pede malesuada in imperdiet et commodo vulputate justo in blandit ultrices enim lorem ipsum dolor', 'Consumer Services', 'Babbleopia', '¥97994.01', '4404 Sullivan Point', 'Sweden', '5/21/2018')\n" +
",(142, 'Web Designer II', 'Full_Time', 'pellentesque quisque porta volutpat erat quisque erat eros viverra eget congue eget semper rutrum nulla nunc purus phasellus in felis donec semper sapien a libero nam dui proin leo odio porttitor id consequat in consequat ut nulla sed accumsan felis ut at dolor quis odio consequat varius integer ac leo pellentesque ultrices mattis odio donec vitae nisi nam', 'Construction', 'Kwimbee', '€30510,18', '47013 5th Lane', 'Philippines', '12/13/2018')\n" +
",(143, 'Marketing Assistant', 'Internship', 'vel est donec odio justo sollicitudin ut suscipit a feugiat et eros vestibulum ac est lacinia nisi venenatis tristique fusce congue diam id ornare imperdiet sapien urna pretium nisl ut volutpat sapien arcu sed augue aliquam erat volutpat in congue etiam justo etiam pretium iaculis justo in hac habitasse platea dictumst etiam faucibus cursus urna ut tellus nulla ut erat id mauris vulputate elementum nullam varius nulla facilisi cras non velit nec nisi vulputate nonummy maecenas tincidunt lacus at velit vivamus vel nulla eget eros elementum pellentesque quisque porta volutpat erat quisque erat eros viverra', 'Construction', 'Voonte', '€32908,73', '86882 Trailsway Center', 'Brazil', '5/14/2018')\n" +
",(144, 'Statistician III', 'Temporary', 'in ante vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae duis faucibus accumsan odio curabitur convallis duis consequat dui nec nisi volutpat eleifend donec ut dolor morbi vel lectus in quam fringilla rhoncus mauris enim leo rhoncus sed vestibulum sit amet cursus id turpis integer aliquet massa id lobortis convallis tortor risus dapibus augue vel accumsan tellus nisi eu orci mauris lacinia sapien quis libero nullam sit amet turpis elementum ligula vehicula consequat morbi a ipsum integer a nibh in quis justo maecenas rhoncus aliquam lacus morbi quis tortor id nulla', 'Basic Industries', 'Yakitri', '£58555.34', '3204 Randy Avenue', 'Philippines', '3/16/2018')\n" +
",(145, 'Physical Therapy Assistant', 'Internship', 'rhoncus aliquet pulvinar sed nisl nunc rhoncus dui vel sem sed sagittis nam congue risus semper porta volutpat quam pede lobortis ligula sit amet eleifend pede libero quis orci nullam molestie nibh in lectus pellentesque at nulla suspendisse potenti cras in purus eu magna vulputate luctus cum sociis natoque penatibus et magnis dis parturient montes nascetur ridiculus mus vivamus vestibulum sagittis sapien cum', 'Construction', 'Zazio', '$50267.60', '35 Dennis Pass', 'Brazil', '2/3/2019')\n" +
",(146, 'VP Quality Control', 'Temporary', 'cras pellentesque volutpat dui maecenas tristique est et tempus semper est quam pharetra magna ac consequat metus sapien ut nunc vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae mauris viverra diam vitae quam suspendisse potenti nullam porttitor lacus at turpis donec posuere metus vitae ipsum aliquam non mauris morbi non lectus aliquam sit amet diam in magna bibendum imperdiet nullam orci pede venenatis non sodales sed tincidunt eu felis fusce posuere felis sed lacus morbi sem mauris laoreet ut rhoncus aliquet pulvinar sed nisl nunc rhoncus dui vel sem sed', 'Public Utilities', 'Dynava', '¥88976.85', '4451 Dahle Point', 'Egypt', '9/5/2018')\n" +
",(147, 'Project Manager', 'Part_Time', 'orci luctus et ultrices posuere cubilia curae nulla dapibus dolor vel est donec odio justo sollicitudin ut suscipit a feugiat et eros vestibulum ac est lacinia nisi venenatis tristique fusce congue diam id ornare imperdiet sapien urna pretium nisl ut volutpat sapien arcu sed augue aliquam erat volutpat in congue etiam justo etiam pretium iaculis justo in hac habitasse platea dictumst etiam faucibus cursus urna ut tellus nulla ut erat id', 'Consumer Services', 'Brainsphere', '¥36088.81', '22166 Red Cloud Court', 'Czech Republic', '3/15/2018')\n" +
",(148, 'Food Chemist', 'Temporary', 'orci mauris lacinia sapien quis libero nullam sit amet turpis elementum ligula vehicula consequat morbi a ipsum integer a nibh in quis justo maecenas rhoncus aliquam lacus morbi quis tortor id nulla ultrices aliquet maecenas leo odio condimentum id luctus nec molestie sed justo pellentesque viverra pede ac diam cras pellentesque volutpat dui maecenas tristique est et tempus semper est quam pharetra magna ac consequat metus sapien ut nunc vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae mauris viverra diam vitae quam suspendisse potenti nullam porttitor', 'Finance', 'Browsecat', '$62324.31', '6 Pawling Court', 'Indonesia', '3/15/2018')\n" +
",(149, 'Biostatistician IV', 'Part_Time', 'magna vulputate luctus cum sociis natoque penatibus et magnis dis parturient montes nascetur ridiculus mus vivamus vestibulum sagittis sapien cum sociis natoque penatibus et magnis dis parturient montes nascetur ridiculus mus etiam vel augue vestibulum rutrum rutrum neque aenean auctor gravida sem praesent id massa id nisl venenatis lacinia aenean sit amet justo morbi ut odio cras mi pede malesuada in imperdiet et commodo vulputate justo', 'Construction', 'Feedbug', '€29892,43', '144 8th Alley', 'Peru', '10/28/2018')\n" +
",(150, 'VP Sales', 'Temporary', 'in hac habitasse platea dictumst morbi vestibulum velit id pretium iaculis diam erat fermentum justo nec condimentum neque sapien placerat ante nulla justo aliquam quis turpis eget elit sodales scelerisque mauris sit amet eros suspendisse accumsan tortor quis turpis sed ante vivamus tortor duis mattis egestas metus aenean fermentum donec ut mauris eget massa tempor convallis nulla neque libero convallis eget eleifend luctus ultricies eu nibh quisque id justo sit amet sapien dignissim vestibulum vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae nulla dapibus dolor vel est donec odio justo sollicitudin ut suscipit a feugiat et eros vestibulum ac est lacinia nisi venenatis tristique fusce congue diam', 'Basic Industries', 'Photofeed', '$40047.50', '62 Sullivan Crossing', 'Indonesia', '2/27/2019')\n" +
",(151, 'Clinical Specialist', 'Permanent', 'imperdiet sapien urna pretium nisl ut volutpat sapien arcu sed augue aliquam erat volutpat in congue etiam justo etiam pretium iaculis justo in hac habitasse platea dictumst etiam faucibus cursus urna ut tellus nulla ut erat id mauris vulputate elementum nullam varius nulla facilisi cras non velit nec nisi vulputate nonummy maecenas tincidunt lacus at velit vivamus vel nulla eget eros elementum pellentesque quisque porta volutpat erat quisque erat eros viverra eget congue eget semper rutrum nulla nunc purus phasellus in felis donec semper sapien a libero nam dui proin leo odio porttitor id consequat in consequat ut nulla sed accumsan felis ut at dolor quis odio consequat varius integer ac leo pellentesque ultrices mattis odio donec vitae nisi nam ultrices', 'Consumer Services', 'Podcat', '€77857,72', '67205 Randy Place', 'Philippines', '4/24/2018')\n" +
",(152, 'Web Developer I', 'Part_Time', 'maecenas tristique est et tempus semper est quam pharetra magna ac consequat metus sapien ut nunc vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae mauris viverra diam vitae quam suspendisse potenti nullam porttitor lacus at turpis donec posuere metus vitae ipsum aliquam non mauris morbi non lectus aliquam sit amet diam in magna bibendum imperdiet nullam orci pede venenatis non sodales sed tincidunt eu felis fusce posuere felis sed lacus morbi sem mauris laoreet ut rhoncus aliquet pulvinar sed nisl', 'Consumer Services', 'Realcube', '£70808.97', '684 Eastlawn Pass', 'China', '12/19/2018')\n" +
",(153, 'Statistician IV', 'Full_Time', 'orci mauris lacinia sapien quis libero nullam sit amet turpis elementum ligula vehicula consequat morbi a ipsum integer a nibh in quis justo maecenas rhoncus aliquam lacus morbi quis tortor id nulla ultrices aliquet maecenas leo odio condimentum id luctus nec molestie sed justo pellentesque viverra pede ac diam cras pellentesque volutpat dui maecenas tristique est et tempus semper est quam pharetra magna ac consequat metus sapien ut nunc vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae mauris viverra diam vitae quam suspendisse potenti nullam porttitor lacus at turpis donec posuere metus vitae ipsum aliquam non mauris morbi non', 'Public Utilities', 'Bluejam', '£70141.19', '1 Warner Trail', 'Nicaragua', '11/26/2018')\n" +
",(154, 'Payment Adjustment Coordinator', 'Permanent', 'quis orci nullam molestie nibh in lectus pellentesque at nulla suspendisse potenti cras in purus eu magna vulputate luctus cum sociis natoque penatibus et magnis dis parturient montes nascetur ridiculus mus vivamus vestibulum sagittis sapien cum sociis natoque penatibus et magnis dis parturient montes nascetur ridiculus mus etiam vel augue vestibulum rutrum rutrum neque aenean auctor gravida sem praesent id massa id nisl venenatis lacinia', 'Consumer Services', 'Lajo', '£99455.52', '9 Arrowood Street', 'China', '9/21/2018')\n" +
",(155, 'Nurse', 'Temporary', 'ac est lacinia nisi venenatis tristique fusce congue diam id ornare imperdiet sapien urna pretium nisl ut volutpat sapien arcu sed augue aliquam erat volutpat in congue etiam justo etiam pretium iaculis justo in hac habitasse platea dictumst etiam faucibus cursus urna ut tellus nulla', 'Basic Industries', 'Geba', '£47926.38', '84694 Starling Terrace', 'Mexico', '6/10/2018')\n" +
",(156, 'Budget/Accounting Analyst I', 'Internship', 'platea dictumst etiam faucibus cursus urna ut tellus nulla ut erat id mauris vulputate elementum nullam varius nulla facilisi cras non velit nec nisi vulputate nonummy maecenas tincidunt lacus at velit vivamus vel nulla eget eros elementum pellentesque quisque porta volutpat erat quisque erat eros viverra eget congue eget semper rutrum nulla nunc purus phasellus in felis donec semper sapien a libero nam dui proin leo odio porttitor id consequat in consequat ut nulla sed accumsan', 'Construction', 'Vinte', '€27243,81', '909 Thackeray Trail', 'South Korea', '10/13/2018')\n" +
",(157, 'Database Administrator III', 'Temporary', 'cubilia curae nulla dapibus dolor vel est donec odio justo sollicitudin ut suscipit a feugiat et eros vestibulum ac est lacinia nisi venenatis tristique fusce congue diam id ornare imperdiet sapien urna pretium nisl ut volutpat sapien arcu sed augue aliquam erat volutpat in congue etiam justo etiam pretium iaculis justo in hac habitasse platea dictumst etiam faucibus cursus urna ut tellus nulla ut erat id mauris vulputate elementum nullam varius nulla facilisi cras non velit nec nisi vulputate nonummy maecenas tincidunt lacus at velit vivamus vel nulla eget eros elementum pellentesque quisque porta volutpat erat quisque erat eros viverra eget congue eget semper rutrum nulla nunc purus phasellus in felis donec semper sapien a libero', 'Public Utilities', 'Blogpad', '$75288.06', '7 Summerview Road', 'Poland', '7/17/2018')\n" +
",(158, 'Quality Engineer', 'Temporary', 'etiam pretium iaculis justo in hac habitasse platea dictumst etiam faucibus cursus urna ut tellus nulla ut erat id mauris vulputate elementum nullam varius nulla facilisi cras non velit nec nisi vulputate nonummy maecenas tincidunt lacus at velit vivamus vel nulla eget eros elementum pellentesque quisque porta volutpat erat quisque erat eros viverra eget congue eget semper rutrum nulla nunc purus phasellus in felis donec semper sapien a libero nam dui proin leo odio porttitor id consequat in consequat ut nulla sed accumsan felis ut at dolor quis odio consequat varius integer ac leo pellentesque ultrices mattis odio donec', 'Basic Industries', 'Dynazzy', '$57510.69', '5792 Nova Road', 'China', '5/9/2018')\n" +
",(159, 'Food Chemist', 'Temporary', 'mauris laoreet ut rhoncus aliquet pulvinar sed nisl nunc rhoncus dui vel sem sed sagittis nam congue risus semper porta volutpat quam pede lobortis ligula sit amet eleifend pede libero quis orci nullam molestie nibh in lectus pellentesque at nulla suspendisse potenti cras in purus eu magna vulputate luctus cum sociis natoque penatibus et magnis dis parturient montes', 'Basic Industries', 'Oloo', '$84567.69', '046 Sommers Trail', 'Indonesia', '1/11/2019')\n" +
",(160, 'Programmer I', 'Full_Time', 'convallis tortor risus dapibus augue vel accumsan tellus nisi eu orci mauris lacinia sapien quis libero nullam sit amet turpis elementum ligula vehicula consequat morbi a ipsum integer a nibh in quis justo maecenas rhoncus aliquam lacus morbi quis tortor id nulla ultrices aliquet maecenas leo odio condimentum id luctus nec molestie sed justo pellentesque viverra pede ac diam cras pellentesque volutpat dui maecenas tristique est et tempus semper est quam pharetra magna ac consequat metus sapien ut nunc vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae mauris viverra diam vitae quam suspendisse potenti nullam porttitor lacus at turpis donec posuere metus vitae ipsum aliquam non mauris morbi non lectus aliquam sit amet diam in magna bibendum imperdiet nullam', 'Construction', 'Pixonyx', '$67663.85', '0 Carey Place', 'Indonesia', '8/15/2018')\n" +
",(161, 'Web Designer I', 'Internship', 'sit amet lobortis sapien sapien non mi integer ac neque duis bibendum morbi non quam nec dui luctus rutrum nulla tellus in sagittis dui vel nisl duis ac nibh fusce lacus purus aliquet at feugiat non pretium quis lectus suspendisse potenti in eleifend quam a odio in hac habitasse platea dictumst maecenas ut massa quis augue luctus tincidunt nulla mollis molestie lorem quisque ut erat curabitur gravida nisi at nibh in hac habitasse platea dictumst aliquam augue quam sollicitudin vitae consectetuer eget rutrum at lorem integer tincidunt ante vel ipsum praesent blandit lacinia erat vestibulum sed magna at nunc commodo placerat praesent blandit nam nulla integer pede justo lacinia eget tincidunt eget tempus vel pede morbi', 'Finance', 'Ozu', '¥74896.68', '56250 Main Trail', 'Indonesia', '4/22/2018')\n" +
",(162, 'Community Outreach Specialist', 'Internship', 'tempus semper est quam pharetra magna ac consequat metus sapien ut nunc vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae mauris viverra diam vitae quam suspendisse potenti nullam porttitor lacus at turpis donec posuere metus', 'Basic Industries', 'Tazz', '€98542,50', '718 Bunting Place', 'China', '8/1/2018')\n" +
",(163, 'VP Sales', 'Permanent', 'elementum nullam varius nulla facilisi cras non velit nec nisi vulputate nonummy maecenas tincidunt lacus at velit vivamus vel nulla eget eros elementum pellentesque quisque porta volutpat erat quisque erat eros viverra eget congue eget semper rutrum nulla nunc purus phasellus in felis donec semper sapien a libero nam dui proin leo odio porttitor id consequat in consequat ut nulla sed accumsan felis ut at dolor quis odio consequat varius integer ac leo pellentesque ultrices mattis odio donec vitae nisi nam ultrices libero non mattis pulvinar nulla pede ullamcorper augue a suscipit nulla elit ac nulla sed vel enim sit amet nunc viverra dapibus nulla suscipit ligula in lacus curabitur at ipsum ac tellus semper interdum mauris', 'Public Utilities', 'Skippad', '£33984.01', '6 Harbort Parkway', 'Poland', '12/27/2018')\n" +
",(164, 'Director of Sales', 'Full_Time', 'nisl nunc rhoncus dui vel sem sed sagittis nam congue risus semper porta volutpat quam pede lobortis ligula sit amet eleifend pede libero quis orci nullam molestie nibh in lectus pellentesque at nulla suspendisse potenti cras in purus eu magna vulputate luctus cum sociis natoque penatibus et magnis dis parturient montes nascetur ridiculus mus vivamus vestibulum sagittis sapien cum sociis natoque penatibus et magnis dis parturient montes nascetur ridiculus mus etiam vel augue vestibulum rutrum rutrum neque aenean auctor gravida', 'Finance', 'Miboo', '€55860,19', '7 Killdeer Way', 'Indonesia', '3/14/2018')\n" +
",(165, 'Community Outreach Specialist', 'Part_Time', 'vel nulla eget eros elementum pellentesque quisque porta volutpat erat quisque erat eros viverra eget congue eget semper rutrum nulla nunc purus phasellus in felis donec semper sapien a libero nam dui proin leo odio porttitor id consequat in consequat ut nulla sed accumsan felis ut at dolor quis odio consequat varius integer ac leo pellentesque ultrices mattis odio donec vitae nisi nam ultrices libero non', 'Consumer Services', 'Pixonyx', '€98871,07', '1316 John Wall Point', 'Kenya', '5/28/2018')\n" +
",(166, 'Account Representative IV', 'Part_Time', 'lacinia nisi venenatis tristique fusce congue diam id ornare imperdiet sapien urna pretium nisl ut volutpat sapien arcu sed augue aliquam erat volutpat in congue etiam justo etiam pretium iaculis justo in hac habitasse platea dictumst etiam faucibus cursus urna ut tellus nulla ut erat id mauris vulputate elementum nullam varius nulla facilisi cras non velit nec nisi vulputate nonummy maecenas tincidunt lacus at velit vivamus vel nulla eget eros elementum pellentesque quisque porta volutpat erat quisque erat eros viverra eget congue eget semper rutrum nulla nunc purus phasellus in felis donec semper sapien a libero nam dui proin leo odio porttitor id consequat in consequat ut nulla sed accumsan felis ut at dolor quis odio consequat', 'Consumer Services', 'Bluezoom', '£32860.26', '006 Raven Terrace', 'Sweden', '4/1/2018')\n" +
",(167, 'Senior Quality Engineer', 'Temporary', 'platea dictumst etiam faucibus cursus urna ut tellus nulla ut erat id mauris vulputate elementum nullam varius nulla facilisi cras non velit nec nisi vulputate nonummy maecenas tincidunt lacus at velit vivamus vel nulla eget eros elementum pellentesque quisque porta volutpat erat quisque erat eros viverra eget congue eget semper rutrum nulla nunc purus phasellus in felis donec semper sapien a libero nam dui proin leo odio porttitor id consequat in consequat ut nulla sed accumsan felis ut at dolor quis odio consequat varius integer ac leo pellentesque ultrices mattis odio donec vitae nisi nam ultrices libero non mattis pulvinar nulla pede ullamcorper augue a suscipit nulla elit ac nulla sed vel enim sit amet nunc viverra dapibus nulla suscipit ligula in lacus', 'Public Utilities', 'Riffpedia', '¥32208.58', '14962 Arapahoe Lane', 'China', '6/24/2018')\n" +
",(168, 'Mechanical Systems Engineer', 'Internship', 'nonummy maecenas tincidunt lacus at velit vivamus vel nulla eget eros elementum pellentesque quisque porta volutpat erat quisque erat eros viverra eget congue eget semper rutrum nulla nunc purus phasellus in felis donec semper sapien a libero nam dui proin leo odio porttitor id consequat in consequat ut nulla sed accumsan felis ut at dolor quis odio consequat varius integer ac leo pellentesque ultrices mattis odio donec vitae nisi nam ultrices libero non mattis pulvinar nulla pede ullamcorper augue a suscipit nulla elit ac nulla sed vel enim sit amet', 'Basic Industries', 'Wordware', '€51098,29', '2 Briar Crest Point', 'Kyrgyzstan', '6/4/2018')\n" +
",(169, 'Budget/Accounting Analyst IV', 'Temporary', 'a pede posuere nonummy integer non velit donec diam neque vestibulum eget vulputate ut ultrices vel augue vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae donec pharetra magna vestibulum aliquet ultrices erat tortor sollicitudin mi sit amet lobortis', 'Basic Industries', 'Quaxo', '¥88666.97', '728 Brickson Park Plaza', 'Central African Republic', '7/3/2018')\n" +
",(170, 'Senior Quality Engineer', 'Temporary', 'convallis morbi odio odio elementum eu interdum eu tincidunt in leo maecenas pulvinar lobortis est phasellus sit amet erat nulla tempus vivamus in felis eu sapien cursus vestibulum proin eu mi nulla ac enim in tempor turpis nec euismod scelerisque quam turpis adipiscing lorem vitae mattis nibh', 'Consumer Services', 'Livefish', '€90671,70', '6 La Follette Junction', 'Indonesia', '8/6/2018')\n" +
",(171, 'Automation Specialist III', 'Part_Time', 'in libero ut massa volutpat convallis morbi odio odio elementum eu interdum eu tincidunt in leo maecenas pulvinar lobortis est phasellus sit amet erat nulla tempus vivamus in felis eu sapien cursus vestibulum proin eu mi nulla ac enim in tempor turpis nec euismod scelerisque quam turpis adipiscing lorem vitae mattis nibh ligula nec sem duis aliquam convallis nunc proin at turpis a pede posuere nonummy integer non velit donec diam neque vestibulum eget vulputate ut ultrices vel augue vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae donec pharetra magna vestibulum aliquet ultrices erat tortor sollicitudin mi sit amet lobortis sapien sapien non mi integer ac neque duis bibendum morbi non quam nec dui luctus rutrum nulla tellus in sagittis', 'Finance', 'Flashdog', '$23982.22', '634 Hansons Place', 'Peru', '7/18/2018')\n" +
",(172, 'Project Manager', 'Internship', 'lacinia eget tincidunt eget tempus vel pede morbi porttitor lorem id ligula suspendisse ornare consequat lectus in est risus auctor sed tristique in tempus sit amet sem fusce consequat nulla nisl nunc nisl duis bibendum felis sed interdum venenatis turpis enim blandit mi in porttitor pede justo eu massa donec dapibus duis at velit eu est congue elementum in hac', 'Finance', 'Tagcat', '¥99247.87', '86722 Waywood Way', 'United States', '5/8/2018')\n" +
",(173, 'Senior Financial Analyst', 'Part_Time', 'sem mauris laoreet ut rhoncus aliquet pulvinar sed nisl nunc rhoncus dui vel sem sed sagittis nam congue risus semper porta volutpat quam pede lobortis ligula sit amet eleifend pede libero quis orci nullam molestie nibh in lectus pellentesque at nulla suspendisse potenti cras in purus', 'Consumer Services', 'Divape', '$57488.18', '66 Logan Place', 'Cameroon', '11/23/2018')\n" +
",(174, 'Geological Engineer', 'Part_Time', 'sed nisl nunc rhoncus dui vel sem sed sagittis nam congue risus semper porta volutpat quam pede lobortis ligula sit amet eleifend pede libero quis orci nullam molestie nibh in lectus pellentesque at nulla suspendisse potenti cras in purus eu magna vulputate luctus cum sociis natoque penatibus et magnis dis parturient montes nascetur ridiculus mus', 'Consumer Services', 'Aivee', '€48589,99', '87 Veith Park', 'France', '12/8/2018')\n" +
",(175, 'Senior Cost Accountant', 'Permanent', 'lacus morbi sem mauris laoreet ut rhoncus aliquet pulvinar sed nisl nunc rhoncus dui vel sem sed sagittis nam congue risus semper porta volutpat quam pede lobortis ligula sit amet eleifend pede libero quis orci nullam molestie nibh in lectus pellentesque at nulla suspendisse potenti cras in purus', 'Public Utilities', 'Jaxspan', '€65026,36', '3379 Green Ridge Pass', 'Honduras', '7/5/2018')\n" +
",(176, 'General Manager', 'Full_Time', 'hac habitasse platea dictumst maecenas ut massa quis augue luctus tincidunt nulla mollis molestie lorem quisque ut erat curabitur gravida nisi at nibh in hac habitasse platea dictumst aliquam augue quam sollicitudin vitae consectetuer eget rutrum at lorem integer tincidunt ante vel', 'Construction', 'Agimba', '¥32606.44', '30438 Gina Drive', 'China', '6/28/2018')\n" +
",(177, 'Mechanical Systems Engineer', 'Part_Time', 'consectetuer adipiscing elit proin risus praesent lectus vestibulum quam sapien varius ut blandit non interdum in ante vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae duis faucibus accumsan odio curabitur convallis duis consequat dui nec nisi volutpat eleifend donec ut dolor morbi vel lectus in quam fringilla rhoncus mauris enim leo rhoncus sed vestibulum sit amet cursus id turpis integer aliquet massa id lobortis convallis tortor risus dapibus augue vel accumsan tellus nisi eu orci mauris lacinia sapien quis libero nullam sit amet turpis elementum ligula vehicula consequat morbi a ipsum integer a nibh in quis', 'Consumer Services', 'Rhyloo', '$68980.88', '1 Bashford Park', 'China', '9/19/2018')\n" +
",(178, 'Business Systems Development Analyst', 'Temporary', 'eleifend pede libero quis orci nullam molestie nibh in lectus pellentesque at nulla suspendisse potenti cras in purus eu magna vulputate luctus cum sociis natoque penatibus et magnis dis parturient montes nascetur ridiculus mus vivamus vestibulum sagittis sapien cum sociis natoque penatibus et magnis dis parturient montes nascetur ridiculus mus etiam vel augue', 'Consumer Services', 'DabZ', '¥61926.46', '5 Mockingbird Road', 'Czech Republic', '5/16/2018')\n" +
",(179, 'Project Manager', 'Part_Time', 'vel lectus in quam fringilla rhoncus mauris enim leo rhoncus sed vestibulum sit amet cursus id turpis integer aliquet massa id lobortis convallis tortor risus dapibus augue vel accumsan tellus nisi eu orci mauris lacinia sapien quis libero nullam sit amet turpis elementum ligula vehicula consequat morbi a ipsum integer a nibh in quis justo maecenas rhoncus aliquam lacus morbi quis tortor id nulla ultrices aliquet maecenas leo odio condimentum id luctus nec molestie', 'Finance', 'Wordtune', '¥96973.65', '4 American Way', 'Brazil', '8/22/2018')\n" +
",(180, 'Technical Writer', 'Internship', 'in faucibus orci luctus et ultrices posuere cubilia curae duis faucibus accumsan odio curabitur convallis duis consequat dui nec nisi volutpat eleifend donec ut dolor morbi vel lectus in quam fringilla rhoncus mauris enim leo rhoncus sed vestibulum sit amet cursus id turpis integer aliquet massa', 'Finance', 'Feedbug', '$85372.40', '608 Surrey Point', 'Portugal', '2/3/2019')");


        try {
            stmt = con.createStatement();
            SearchGUI.stmt.executeUpdate(populate1);
            SearchGUI.stmt.executeUpdate(populate2);
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                System.out.println("Could not close query");
            }

        }

    }

    ;
        /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     * */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuBar1 = new java.awt.MenuBar();
        menu1 = new java.awt.Menu();
        menu2 = new java.awt.Menu();
        menuBar2 = new java.awt.MenuBar();
        menu3 = new java.awt.Menu();
        menu4 = new java.awt.Menu();
        menuBar3 = new java.awt.MenuBar();
        menu5 = new java.awt.Menu();
        menu6 = new java.awt.Menu();
        searchFrame = new javax.swing.JInternalFrame();
        jPanel1 = new javax.swing.JPanel();
        signInButton = new javax.swing.JLabel();
        searchTextField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        searchFilters = new javax.swing.JPanel();
        jobTypeLable = new javax.swing.JLabel();
        partTimeCheckBox = new javax.swing.JCheckBox();
        permanentCheckBox = new javax.swing.JCheckBox();
        temporaryCheckBox = new javax.swing.JCheckBox();
        internshipCheckBox = new javax.swing.JCheckBox();
        jobSectorLable = new javax.swing.JLabel();
        fullTimeCheckBox = new javax.swing.JCheckBox();
        consumerServiceCheckBox = new javax.swing.JCheckBox();
        financeCheckBox = new javax.swing.JCheckBox();
        constructionCheckBox = new javax.swing.JCheckBox();
        transportationCheckBox = new javax.swing.JCheckBox();
        publicUtilitiesCheckBox = new javax.swing.JCheckBox();
        basicIndustriesCheckBox = new javax.swing.JCheckBox();
        countryLable = new javax.swing.JLabel();
        spainCheckBox = new javax.swing.JCheckBox();
        germanyCheckBox = new javax.swing.JCheckBox();
        franceCheckBox = new javax.swing.JCheckBox();
        norwayCheckBox = new javax.swing.JCheckBox();
        greeceCheckBox = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane(resultsPanel);
        resultsPanel = new javax.swing.JPanel();

        menu1.setLabel("File");
        menuBar1.add(menu1);

        menu2.setLabel("Edit");
        menuBar1.add(menu2);

        menu3.setLabel("File");
        menuBar2.add(menu3);

        menu4.setLabel("Edit");
        menuBar2.add(menu4);

        menu5.setLabel("File");
        menuBar3.add(menu5);

        menu6.setLabel("Edit");
        menuBar3.add(menu6);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        searchFrame.setVisible(true);

        signInButton.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        signInButton.setText("Sign in");
        signInButton.setAlignmentY(0.0F);

        searchTextField.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        searchTextField.setText("Search");
        searchTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchTextFieldFocusLost(evt);
            }
        });
        searchTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTextFieldActionPerformed(evt);
            }
        });

        searchButton.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        searchButton.setText("Find Jobs ");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(signInButton, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 696, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(signInButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchTextField)
                    .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jobTypeLable.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jobTypeLable.setText("Job Type ");

        partTimeCheckBox.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        partTimeCheckBox.setText("Part-time");

        permanentCheckBox.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        permanentCheckBox.setText("Permanent ");

        temporaryCheckBox.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        temporaryCheckBox.setText("Temporary");

        internshipCheckBox.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        internshipCheckBox.setText("Intership");

        jobSectorLable.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jobSectorLable.setText("Job Sector");

        fullTimeCheckBox.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        fullTimeCheckBox.setText("Full-time ");
        fullTimeCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fullTimeCheckBoxActionPerformed(evt);
            }
        });

        consumerServiceCheckBox.setText("Consumer Services");
        consumerServiceCheckBox.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                consumerServiceCheckBoxStateChanged(evt);
            }
        });
        consumerServiceCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consumerServiceCheckBoxActionPerformed(evt);
            }
        });

        financeCheckBox.setText("Finance");
        financeCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                financeCheckBoxActionPerformed(evt);
            }
        });

        constructionCheckBox.setText("Construction ");
        constructionCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                constructionCheckBoxActionPerformed(evt);
            }
        });

        transportationCheckBox.setText("Transportation");
        transportationCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transportationCheckBoxActionPerformed(evt);
            }
        });

        publicUtilitiesCheckBox.setText("Public Utilities");

        basicIndustriesCheckBox.setText("Basic Industries");
        basicIndustriesCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                basicIndustriesCheckBoxActionPerformed(evt);
            }
        });

        countryLable.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        countryLable.setText("Country");

        spainCheckBox.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        spainCheckBox.setText("Spain");

        germanyCheckBox.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        germanyCheckBox.setText("Germany");
        germanyCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                germanyCheckBoxActionPerformed(evt);
            }
        });

        franceCheckBox.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        franceCheckBox.setText("France");

        norwayCheckBox.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        norwayCheckBox.setText("Norway");

        greeceCheckBox.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        greeceCheckBox.setText("Greece");

        javax.swing.GroupLayout searchFiltersLayout = new javax.swing.GroupLayout(searchFilters);
        searchFilters.setLayout(searchFiltersLayout);
        searchFiltersLayout.setHorizontalGroup(
            searchFiltersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fullTimeCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jobSectorLable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(financeCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(searchFiltersLayout.createSequentialGroup()
                .addGroup(searchFiltersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(consumerServiceCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(constructionCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(basicIndustriesCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(publicUtilitiesCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(transportationCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(searchFiltersLayout.createSequentialGroup()
                .addGroup(searchFiltersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jobTypeLable, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(partTimeCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(permanentCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(temporaryCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(internshipCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(countryLable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(spainCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(germanyCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(franceCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(norwayCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(greeceCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        searchFiltersLayout.setVerticalGroup(
            searchFiltersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchFiltersLayout.createSequentialGroup()
                .addComponent(jobSectorLable, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(consumerServiceCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(financeCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(constructionCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(transportationCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(basicIndustriesCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(publicUtilitiesCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jobTypeLable, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fullTimeCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(partTimeCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(permanentCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(temporaryCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(internshipCheckBox)
                .addGap(18, 18, 18)
                .addComponent(countryLable, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spainCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(germanyCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(franceCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(norwayCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(greeceCheckBox)
                .addGap(0, 16, Short.MAX_VALUE))
        );

        resultsPanel.setLayout(new javax.swing.BoxLayout(resultsPanel, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(resultsPanel);

        javax.swing.GroupLayout searchFrameLayout = new javax.swing.GroupLayout(searchFrame.getContentPane());
        searchFrame.getContentPane().setLayout(searchFrameLayout);
        searchFrameLayout.setHorizontalGroup(
            searchFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(searchFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchFilters, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(searchFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(searchFrameLayout.createSequentialGroup()
                    .addGap(164, 164, 164)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        searchFrameLayout.setVerticalGroup(
            searchFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchFrameLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchFilters, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(searchFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchFrameLayout.createSequentialGroup()
                    .addGap(77, 77, 77)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(searchFrame)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(searchFrame)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void germanyCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_germanyCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_germanyCheckBoxActionPerformed

    private void basicIndustriesCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_basicIndustriesCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_basicIndustriesCheckBoxActionPerformed

    private void transportationCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transportationCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_transportationCheckBoxActionPerformed

    private void constructionCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_constructionCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_constructionCheckBoxActionPerformed

    private void financeCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_financeCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_financeCheckBoxActionPerformed

    private void consumerServiceCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consumerServiceCheckBoxActionPerformed

    }//GEN-LAST:event_consumerServiceCheckBoxActionPerformed

    private void consumerServiceCheckBoxStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_consumerServiceCheckBoxStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_consumerServiceCheckBoxStateChanged

    private void fullTimeCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fullTimeCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fullTimeCheckBoxActionPerformed

    /**
     * Creates the SQL query from the suer inputs of the search screen and
     * clears the displayed results.
     */
    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed

        searchSql += "( Job_Title = '" + keyword + "'"
                + " or Job_Type = '" + keyword + "'"
                + " or Country = '" + keyword + "'"
                + " or Job_Description = '" + keyword + "'"
                + " or Sector = '" + keyword + "'"
                + " or Company_Name = '" + keyword + "'"
                + " or Salary = '" + keyword + "')";

        sectorFilter();
        jobTypeFilter();
        countryFilter();
        resultsPanel.removeAll();
        resultsPanel.updateUI();
        search();
    }//GEN-LAST:event_searchButtonActionPerformed

    private void searchTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTextFieldActionPerformed

    }//GEN-LAST:event_searchTextFieldActionPerformed
    /**
     * Sets the keyword for the search to the user input once the focus is lost.
     *
     * @param evt
     */
    private void searchTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchTextFieldFocusLost
        keyword = searchTextField.getText();
    }//GEN-LAST:event_searchTextFieldFocusLost

    private void searchTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchTextFieldFocusGained

    }//GEN-LAST:event_searchTextFieldFocusGained
    /**
     *
     * Adds to the SQL search string based on the check boxes selected for
     * sector.
     *
     */
    private void sectorFilter() {

        if (consumerServiceCheckBox.isSelected()
                || publicUtilitiesCheckBox.isSelected()
                || financeCheckBox.isSelected()
                || constructionCheckBox.isSelected()
                || transportationCheckBox.isSelected()
                || basicIndustriesCheckBox.isSelected()
                || publicUtilitiesCheckBox.isSelected()) {
            ArrayList<String> sectors = new ArrayList<String>();
            searchSql += "and( sector = ";

            if (consumerServiceCheckBox.isSelected()) {
                sectors.add("'Consumer Services'");
            };
            if (financeCheckBox.isSelected()) {
                sectors.add("'Finance'");
            };
            if (constructionCheckBox.isSelected()) {
                sectors.add("'construction'");
            };
            if (transportationCheckBox.isSelected()) {
                sectors.add("'transportation'");
            };
            if (basicIndustriesCheckBox.isSelected()) {
                sectors.add("'BasicIndustries'");
            };
            if (publicUtilitiesCheckBox.isSelected()) {
                sectors.add("'publicUtilities'");
            };
            for (int i = 0; i < sectors.size(); i++) {
                if (i < sectors.size() - 1) {
                    searchSql += sectors.get(i) + " or sector = ";
                } else {
                    searchSql += sectors.get(i) + ")";
                };
            };
        };
    }

    /**
     *
     * Adds to the SQL search string based on the check boxes selected for job
     * type.
     *
     */
    private void jobTypeFilter() {

        if (fullTimeCheckBox.isSelected()
                || partTimeCheckBox.isSelected()
                || permanentCheckBox.isSelected()
                || permanentCheckBox.isSelected()
                || temporaryCheckBox.isSelected()
                || internshipCheckBox.isSelected()) {
            ArrayList<String> jobType = new ArrayList<String>();

            searchSql += "and( Job_Type = ";

            if (fullTimeCheckBox.isSelected()) {
                jobType.add("'FULL_TIME'");
            };
            if (partTimeCheckBox.isSelected()) {
                jobType.add("'PART_TIME'");
            };
            if (permanentCheckBox.isSelected()) {
                jobType.add("'PERMANENT'");
            };
            if (temporaryCheckBox.isSelected()) {
                jobType.add("'TEMPORARY'");
            };
            if (internshipCheckBox.isSelected()) {
                jobType.add("'INTERNSHIP'");
            };
            for (int i = 0; i < jobType.size(); i++) {
                if (i < jobType.size() - 1) {
                    searchSql += jobType.get(i) + " or job_Type = ";
                } else {
                    searchSql += jobType.get(i) + ")";
                };
            };
        };
    }

    /**
     *
     * Adds to the SQL search string based on the check boxes selected for
     * country.
     *
     */
    private void countryFilter() {
        if (spainCheckBox.isSelected()
                || germanyCheckBox.isSelected()
                || franceCheckBox.isSelected()
                || norwayCheckBox.isSelected()
                || greeceCheckBox.isSelected()) {

            ArrayList<String> country = new ArrayList<String>();
            searchSql += "and( country = ";
            if (spainCheckBox.isSelected()) {
                country.add("'Spain'");
            };
            if (germanyCheckBox.isSelected()) {
                country.add("'Germany'");
            };
            if (franceCheckBox.isSelected()) {
                country.add("'France'");
            };
            if (norwayCheckBox.isSelected()) {
                country.add("'Norway'");
            };
            if (greeceCheckBox.isSelected()) {
                country.add("'Greece'");
            };
            for (int i = 0; i < country.size(); i++) {
                if (i < country.size() - 1) {
                    searchSql += country.get(i) + " or country = ";
                } else {
                    searchSql += country.get(i) + ")";
                };
            };
        };
    }

    /**
     *
     * Runs the search SQL based on the string created from the user inputs then
     * displays the results on the GUI.
     *
     */
    public void search() {
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(searchSql);

            if (!rs.next()) {
                searchTextField.setText("no results found");
            } else {

                while (rs.next()) {
                    SearchResult result = new SearchResult();

                    int Job_ID = rs.getInt("Job_ID");
                    String Job_Title = rs.getString("Job_Title");
                    String Job_Type = rs.getString("Job_Type");
                    java.util.Date Date = rs.getDate("APPLY_BY_DATE");
                    String Address = rs.getString("Address");
                    String Country = rs.getString("Country");
                    String Job_Description = rs.getString("Job_Description");
                    String Sector = rs.getString("Sector");
                    String Company_Name = rs.getString("Company_Name");
                    String Salary = rs.getString("Salary");

                    result.jobTitleLable.setText(Job_Title);
                    result.resultsJobTitleLable.setText(Company_Name);
                    result.resultsJobTypeLable.setText(Job_Type);
                    result.resultsApplyByDateLable.setText(Date.toString());
                    result.resultsSalaryLable.setText(Salary);
                    result.resultsCountryLable.setText(Country);
                    result.resultsSectorLable.setText(Sector);
                    result.resultsJobDescriptionLable.setText(Job_Description);
                    System.out.println(Job_Title);
                    resultsPanel.add(result);
                    resultsPanel.revalidate();
                    resultsPanel.repaint();
                }
            }

        } catch (SQLException err) {
            System.out.println(err.getMessage());
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                System.out.println("Could not close query");
            }

        }
        searchSql = "Select * from JOBS where";

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SearchGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox basicIndustriesCheckBox;
    private javax.swing.JCheckBox constructionCheckBox;
    private javax.swing.JCheckBox consumerServiceCheckBox;
    private javax.swing.JLabel countryLable;
    private javax.swing.JCheckBox financeCheckBox;
    private javax.swing.JCheckBox franceCheckBox;
    private javax.swing.JCheckBox fullTimeCheckBox;
    private javax.swing.JCheckBox germanyCheckBox;
    private javax.swing.JCheckBox greeceCheckBox;
    private javax.swing.JCheckBox internshipCheckBox;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jobSectorLable;
    private javax.swing.JLabel jobTypeLable;
    private java.awt.Menu menu1;
    private java.awt.Menu menu2;
    private java.awt.Menu menu3;
    private java.awt.Menu menu4;
    private java.awt.Menu menu5;
    private java.awt.Menu menu6;
    private java.awt.MenuBar menuBar1;
    private java.awt.MenuBar menuBar2;
    private java.awt.MenuBar menuBar3;
    private javax.swing.JCheckBox norwayCheckBox;
    private javax.swing.JCheckBox partTimeCheckBox;
    private javax.swing.JCheckBox permanentCheckBox;
    private javax.swing.JCheckBox publicUtilitiesCheckBox;
    private javax.swing.JPanel resultsPanel;
    private javax.swing.JButton searchButton;
    private javax.swing.JPanel searchFilters;
    private javax.swing.JInternalFrame searchFrame;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JLabel signInButton;
    private javax.swing.JCheckBox spainCheckBox;
    private javax.swing.JCheckBox temporaryCheckBox;
    private javax.swing.JCheckBox transportationCheckBox;
    // End of variables declaration//GEN-END:variables
}
