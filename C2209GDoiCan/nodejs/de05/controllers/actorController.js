const getConnection = require('../db/db');

const createActor = async (req, res) => {
    const { first_name, last_name, gender} = req.body;
    const connection = await getConnection()
    try {
        const result = await connection.execute(
            'INSERT INTO actors(first_name, last_name, gender) VALUES(?, ?, ?)',
            [first_name, last_name, gender]
        );
        console.log('Actor inserted successfully');
        res.status(201).json({
            message: 'Insert successfully',
            data: result
        });
    } catch (error) {
        console.error('Error inserting actor:', error);
        res.status(400).json({
            message: error?.message ?? "",
            code: error.code
        });
    } finally {
        // Release the connection back to the pool
        connection.release();
    }
};

// Controller functions
const getActors = async (req, res) => {
    const connection = await getConnection();
    debugger
    try {
        const [rows] = await connection.execute('SELECT * FROM actors');
        res.status(200).json({
            message: 'Successfully fetched all actors',
            data: rows
        });
    } catch (error) {
        debugger
        console.error('Error fetching actors:', error);
        res.status(500).json({
            message: error?.message ?? "Error fetching actors",
            code: error.code
        });
    } finally {
        // Release the connection back to the pool
        connection.release();
    }
};


const getActorById = async (req, res) => {
    const { id } = req.params;
    const connection = await getConnection();
    try {
        const [rows] = await connection.execute('SELECT * FROM actors WHERE id = ?', [id]);
        if (rows.length === 0) {
            return res.status(404).json({ error: 'Actor not found' });
        }
        res.status(200).json({
            message: 'Successfully fetched actor by ID',
            data: rows[0]
        });
    } catch (error) {
        console.error('Error fetching actor by ID:', error);
        res.status(500).json({
            message: error?.message ?? "Error fetching actor by ID",
            code: error.code
        });
    } finally {
        // Release the connection back to the pool
        connection.release();
    }
}
module.exports = {
    getActors,
    getActorById,
    createActor,
};
