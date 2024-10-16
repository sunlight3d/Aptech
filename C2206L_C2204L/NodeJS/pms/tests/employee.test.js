const assert = require('chai').assert;
const chai = require('chai');
const chaiHttp = require('chai-http');
debugger
const app = require('../app'); 
const should = chai.should();

chai.use(chaiHttp);

describe('Test Employee Insertion', function () {
  it('should insert an employee into the database', function (done) {
    debugger
    // Dữ liệu nhân viên mới
    const newEmployee = {
        FirstName: 'John',
        Code: 'EMP001',
        LastName: 'Doe',
        Address: '123 Main St',
        Phone: '123-456-7890',
        Mobile: '987-654-3210',
        Email: 'john.doe@example.com',
        Photo: 'path-to-photo.jpg',
        CurriculumVitaeType: 'PDF',
        CurriculumVitae: 'path-to-cv.pdf',
        OrganizationID: 1, // ID của tổ chức
        DateofBirth: '1990-01-01T00:00:00Z',
        IndentifyNumber: '123456789',
        IssuedPlace: 'Local Authority',
        IssuedDate: '2010-01-01T00:00:00Z',
        PresentResidence: '456 Another St',
        RecruitedDate: '2021-01-01T00:00:00Z',
        DateOfEnteringOffice: '2021-02-01T00:00:00Z',
        NominatedDate: '2021-03-01T00:00:00Z',
        SexID: 1, // ID của giới tính
        PositionID: 1, // ID của vị trí công việc
        Status: 1, // Trạng thái nhân viên
      };
      

      chai
      .request(app)
      .post('/api/employees')
      .send(newEmployee)
      .end((err, res) => {
        res.should.have.status(201); // Kiểm tra xem server đã trả về status code 201 (Created) hay chưa
        res.body.should.be.a('object'); // Kiểm tra xem server đã trả về một đối tượng JSON hay chưa
        res.body.should.have.property('message').eql('Employee đã được tạo!'); // Kiểm tra nội dung phản hồi từ server
        done();
      });
  });
});
