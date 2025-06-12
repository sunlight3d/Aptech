const router = require('express').Router();
const { Class, ClassStudent, User } = require('../models');

/* GET /api/classes?lecturer_id=2 */
router.get('/', async (req, res, next) => {
  try {
    const where = req.query.lecturer_id ? { lecturer_id: req.query.lecturer_id } : {};
    const list = await Class.findAll({ where });
    res.json(list);
  } catch (e) { next(e); }
});

/* GET /api/classes/:id */
router.get('/:id', async (req, res, next) => {
  try {
    const cls = await Class.findByPk(req.params.id, {
      include: { model: User, through: { attributes: [] } }   // kèm danh sách sinh viên
    });
    if (!cls) return res.sendStatus(404);
    res.json(cls);
  } catch (e) { next(e); }
});

/* POST /api/classes */
router.post('/', async (req, res, next) => {
  try {
    const data = await Class.create(req.body);
    res.status(201).json(data);
  } catch (e) { next(e); }
});

/* PUT /api/classes/:id */
router.put('/:id', async (req, res, next) => {
  try {
    await Class.update(req.body, { where: { class_id: req.params.id } });
    const updated = await Class.findByPk(req.params.id);
    res.json(updated);
  } catch (e) { next(e); }
});

/* DELETE /api/classes/:id */
router.delete('/:id', async (req, res, next) => {
  try {
    await Class.destroy({ where: { class_id: req.params.id } });
    res.sendStatus(204);
  } catch (e) { next(e); }
});

/* ----------- Quản lý sinh viên trong lớp ----------- */

/* GET /api/classes/:id/students */
router.get('/:id/students', async (req, res, next) => {
  try {
    const students = await User.findAll({
      include: { model: Class, where: { class_id: req.params.id }, through: { attributes: [] } },
      attributes: ['user_id','full_name','email']
    });
    res.json(students);
  } catch (e) { next(e); }
});

/* POST /api/classes/:id/students  body:{ student_id } */
router.post('/:id/students', async (req, res, next) => {
  try {
    const row = await ClassStudent.create({
      class_id: req.params.id,
      student_id: req.body.student_id
    });
    res.status(201).json(row);
  } catch (e) { next(e); }
});

/* DELETE /api/classes/:id/students/:student_id */
router.delete('/:id/students/:student_id', async (req, res, next) => {
  try {
    await ClassStudent.destroy({
      where: { class_id: req.params.id, student_id: req.params.student_id }
    });
    res.sendStatus(204);
  } catch (e) { next(e); }
});

module.exports = router;
