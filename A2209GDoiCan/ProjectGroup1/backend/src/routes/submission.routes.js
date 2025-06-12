const router = require('express').Router();
const { Submission, SubComment } = require('../models');
const commentRouter = require('./subcomment.routes');
router.use('/:subId/comments', commentRouter);

/* GET /api/submissions?assignment_id=1 */
router.get('/', async (req, res, next) => {
  try {
    const where = req.query.assignment_id ? { assignment_id: req.query.assignment_id } : {};
    const list = await Submission.findAll({ where });
    res.json(list);
  } catch (e) { next(e); }
});

/* GET /api/submissions/:id (kèm comment) */
router.get('/:id', async (req, res, next) => {
  try {
    const item = await Submission.findByPk(req.params.id, {
      include: { model: SubComment }
    });
    if (!item) return res.sendStatus(404);
    res.json(item);
  } catch (e) { next(e); }
});

/* POST /api/submissions */
router.post('/', async (req, res, next) => {
  try {
    const data = await Submission.create(req.body);
    res.status(201).json(data);
  } catch (e) { next(e); }
});

/* PUT /api/submissions/:id (chấm điểm) */
router.put('/:id', async (req, res, next) => {
  try {
    await Submission.update(req.body, { where: { submission_id: req.params.id } });
    const updated = await Submission.findByPk(req.params.id);
    res.json(updated);
  } catch (e) { next(e); }
});

/* DELETE /api/submissions/:id */
router.delete('/:id', async (req, res, next) => {
  try {
    await Submission.destroy({ where: { submission_id: req.params.id } });
    res.sendStatus(204);
  } catch (e) { next(e); }
});

module.exports = router;
