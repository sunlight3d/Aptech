const router = require('express').Router({ mergeParams: true });
const { SubComment } = require('../models');

/* GET /api/submissions/:subId/comments */
router.get('/', async (req, res, next) => {
  try {
    const list = await SubComment.findAll({ where: { submission_id: req.params.subId } });
    res.json(list);
  } catch (e) { next(e); }
});

/* POST /api/submissions/:subId/comments  body:{ user_id, content } */
router.post('/', async (req, res, next) => {
  try {
    const data = await SubComment.create({
      submission_id: req.params.subId,
      user_id: req.body.user_id,
      content: req.body.content
    });
    res.status(201).json(data);
  } catch (e) { next(e); }
});

/* DELETE /api/submissions/:subId/comments/:id */
router.delete('/:id', async (req, res, next) => {
  try {
    await SubComment.destroy({ where: { comment_id: req.params.id } });
    res.sendStatus(204);
  } catch (e) { next(e); }
});
const commentRouter = require('./subcomment.routes');
router.use('/:subId/comments', commentRouter);
module.exports = router;
