# Standard/Scientific Calculator with Java
## 1. app
## 2. evaluator
## 3. parser
### 1. Standardization
### the parser's basic operand is a `String`. it decodes the string to obtain functions, numbers, brackets and basic operations. 
### To avoid complications here are the standards that the string must follow.
- All functions are 3 character words.
- No spaces between characters in the string.
- Multiplication is represented by '*' (not x or X).
- Subscripts are represented by '_' and superscripts by '^'.
- Absolute value is represented by abs() not |f|.
- Generally, the string should not contain anything weird.
### 2. Considered functions
### These are the considered functions so far:
- [x] `null` - (no function)
- [x] `srt` - (square root)
- [x] `crt` - (cube root)
- [x] `sin`
- [x] `cos`
- [x] `tan`
- [x] `sec`
- [x] `csc`
- [x] `cot`
- [x] `lan` - (ln)
- [x] `log`
- [ ] `prm` - (permutation)
- [ ] `cmb` - (combination)
- [ ] `asi` - (arcsin)
- [ ] `acs` - (arccos)
- [ ] `atn` - (arctan)
- [ ] `ase` - (arcsec)
- [ ] `acc` - (arccsc)
- [ ] `act` - (arccot)
> edit and add more to the list
