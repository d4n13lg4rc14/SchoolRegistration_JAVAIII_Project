create database School_Registration;

use school_registration;

	create table users
	(
		id smallint not null auto_increment,
		first_name nvarchar(50) not null,
		last_name nvarchar(50) not null,
		phone nvarchar(15) null,
		address nvarchar(50) null,
		city nvarchar(50) null,
		state nvarchar(2) null,
		postal_code nvarchar(15) null,
		access_level_id smallint not null, 
		pwd nvarchar(25) not null,
		primary key (id)
    );
    
    create table courses
    (
		id smallint not null auto_increment,
        course_name nvarchar(50) not null,
        numbers_hours smallint not null,
        teacher smallint not null,
        start_date date null,
        finish_date date null,
        course_description nvarchar(250) null,
        total_seat smallint not null,
        availabel_seat smallint not null,
        primary key (id)
	);
    
    create table access_level
    (
		id smallint not null auto_increment,
        access_type nvarchar(25) not null,
        primary key(id)
	);
    
    create table registration
    (
		id smallint not null auto_increment,
        student smallint not null,
        course	smallint not null,
        approved boolean null,
        final_grade decimal null,
        date_registered TIMESTAMP null default CURRENT_TIMESTAMP,
        primary key(id)
	);
    

    
    create table user_option
    (
		user_type nvarchar(25) not null,
        primary key(user_type)
	);
    
    alter table users
    add constraint fk_Users_AccessLevels
	foreign key(access_level_id) references access_level(id);
    
    alter table courses
    add constraint fk_Courses_Users
    foreign key(teacher) references users(id);
    
    alter table courses
    add constraint CK_StartDate_FinishDate check (availabel_seat <= total_seat),
    add constraint CK_NumberOfSeats_NumberOfSeatsAvailable check (availabel_seat >= 0);
    
	alter table registration
    add constraint fk_Registrations_Users 
    foreign key(student) references users(id);
    
    alter table registration
    add constraint fk_Registrations_Courses
    foreign key(course) references courses(id);
    
    DELIMITER //
    create trigger number_of_seat_change after insert
    on registration
    for each row
		begin
			declare courseId integer;
			declare NumberOfSeatsAvailable integer;
            
            set courseid = new.course;
            set NumberOfSeatsAvailable = (select availabel_seat from courses where id = courseid);
            if(NumberOfSeatsAvailable > 0)
				then
					update courses
                    set availabel_seat = NumberOfSeatsAvailable - 1
                    where id = courseid;
			end if;
		
        end//
        
    
    

    

    