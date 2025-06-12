const router = require('express').Router();
const { NotiLog, Assignment } = require('../models');

/* GET /api/notifications?user_id=3 */
router.get('/', async (req, res, next) => {
  try {
    const where = req.query.user_id ? { user_id: req.query.user_id } : {};
    const list = await NotiLog.findAll({
      where,
      include: { model: Assignment, attributes:['title'] },
      order: [['sent_at','DESC']]
    });
    res.json(list);
  } catch (e) { next(e); }
});

module.exports = router;
