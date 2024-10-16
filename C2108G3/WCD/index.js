const pools = [
    [{ symbol: 'VND', amount: 1000000 }, { symbol: 'AUD', amount: 2000000 }],
    [{ symbol: 'AUD', amount: 2000000 }, { symbol: 'AUF', amount: 3000000 }],
    [{ symbol: 'AUF', amount: 1000000 }, { symbol: 'AUG', amount: 4000000 }],
    [{ symbol: 'AUG', amount: 4000000 }, { symbol: 'AUH', amount: 2000000 }],
    [{ symbol: 'AUH', amount: 2000000 }, { symbol: 'VND', amount: 5000000 }],
    [{ symbol: 'VND', amount: 5000000 }, { symbol: 'AUJ', amount: 2000000 }],
    [{ symbol: 'AUJ', amount: 5000000 }, { symbol: 'USD', amount: 20000000 }],
    [{ symbol: 'AUH', amount: 1000000 }, { symbol: 'AUJ', amount: 6000000 }],
    [{ symbol: 'AUJ', amount: 3000000 }, { symbol: 'AUK', amount: 2000000 }],
    [{ symbol: 'AUK', amount: 1000000 }, { symbol: 'USD', amount: 20000000 }]
];

function exchange(fromSymbol, amount, toSymbol) {
    const routes = [];
    const visited = new Set();
    const queue = [{ symbol: fromSymbol, amount: amount, route: [fromSymbol], rate: 1 }];

    while (queue.length > 0) {
        const { symbol, amount, route, rate } = queue.shift();
        if (symbol === toSymbol) {
            routes.push({ route, rate });
        }

        visited.add(symbol);

        for (const pool of pools) {
            const [firstCurrency, secondCurrency] = pool;
            if (firstCurrency.symbol === symbol && !visited.has(secondCurrency.symbol)) {
                const newRate = rate * (secondCurrency.amount / firstCurrency.amount);
                const newAmount = amount * (secondCurrency.amount / firstCurrency.amount);
                const newRoute = route.concat(secondCurrency.symbol);
                queue.push({ symbol: secondCurrency.symbol, amount: newAmount, route: newRoute, rate: newRate });
            }
        }
    }

    return routes;
}

const result = exchange("VND", 1, "USD");
console.log(result);
