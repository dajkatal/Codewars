def change(s, prog, version):
    return (lambda l: (lambda b: str('Program: ' + prog + ' Author: g964 Phone: +1-503-555-0090 Date: 2019-01-01 Version: ' + str(b[-1][-3:] if b[-1][-3:] == '2.0' else version)) if '-' not in b[2][-4:] and b[2][8] == '1' and b[-1][9:].count('.') == 1 and b[-1][9] != '.' else 'ERROR: VERSION or PHONE')(l[:2] + l[3:6]))(s.split("\n"))

print(change('Program title: Primes\nAuthor: Kern\nCorporation: Gold\nPhone: +1-503-555-0009\nDate: Tues April 9, 2005\nVersion: 0.2\nLevel: Alpha', 'Balance', '5'))