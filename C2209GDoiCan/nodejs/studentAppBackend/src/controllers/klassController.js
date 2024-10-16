const Klass = require('../models/klass');
const errorHandler = require('./errorHandler');

// Controller functions
const getKlasses = async (req, res) => {
    const klasses = await Klass.find();
    res.json(klasses);
};

const getKlassById = async (req, res) => {
  const { id } = req.params;
  const klass = await Klass.findById(id);
    if (!klass) {
      return res.status(404).json({ error: 'Klass not found' });
    }
    res.json(klass);
};

const createKlass = async (req, res) => {
    debugger
    const { name, description } = req.body;
    const klass = await Klass.create({ name, description });
    res.status(201).json(klass);
  };
  
const updateKlass = async (req, res) => {
    const { id } = req.params;
    const { name, description } = req.body;
    const klass = await Klass.findByIdAndUpdate(id, { name, description }, { new: true }); //upsert
    if (!klass) {
       return res.status(404).json({ error: 'Klass not found' });
    }
    res.json(klass);
  };
const deleteKlass = async (req, res) => {
    const { id } = req.params;
    const klass = await Klass.findByIdAndDelete(id);
    if (!klass) {
      return res.status(404).json({ error: 'Klass not found' });
    }
    res.json({ message: 'Klass deleted' });
  };

  module.exports = { 
    getKlasses: errorHandler(getKlasses), 
    getKlassById: errorHandler(getKlassById), 
    createKlass: errorHandler(createKlass),  
    updateKlass: errorHandler(updateKlass), 
    deleteKlass: errorHandler(deleteKlass), 
 };
