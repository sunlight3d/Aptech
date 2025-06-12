const router = require('express').Router({ mergeParams: true });
const { Attachment } = require('../models');

/* GET /api/assignments/:assId/attachments */
router.get('/', async (req, res, next) => {
  try {
    const list = await Attachment.findAll({ where: { assignment_id: req.params.assId } });
    res.json(list);
  } catch (e) { next(e); }
});

/* POST /api/assignments/:assId/attachments */
router.post('/', async (req, res, next) => {
  try {
    const data = await Attachment.create({
      assignment_id: req.params.assId,
      file_url: req.body.file_url
    });
    res.status(201).json(data);
  } catch (e) { next(e); }
});

/* DELETE /api/assignments/:assId/attachments/:id */
router.delete('/:id', async (req, res, next) => {
  try {
    await Attachment.destroy({ where: { attachment_id: req.params.id } });
    res.sendStatus(204);
  } catch (e) { next(e); }
});

router.use('/:assId/attachments', attachRouter);
module.exports = router;
