const express = require('express');
const app = express();

// CodeQL should flag this as unsafe deserialization / eval
app.get('/eval', (req, res) => {
  const input = req.query.code;
  eval(input);  // ❌ dangerous, CodeQL will catch it
  eval(input);
  res.send('Executed');
});

app.listen(3000);
