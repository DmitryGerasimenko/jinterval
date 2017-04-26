test g00.l0000 { roundTiesToEven<infsup<bin<53,11>>> [empty] = [empty]_trv <= [empty]_trv }
test g00.l0001 { roundTiesToEven<infsup<bin<53,11>>> [-Infinity,Infinity] = [-Infinity,Infinity]_def <= [-Infinity,Infinity]_def }
test g00.l0002 { roundTiesToEven<infsup<bin<53,11>>> [0,0] = [0,0]_com <= [-0x1p-1074,0x1p-1074]_com }
test g00.l0003 { roundTiesToEven<infsup<bin<53,11>>> [0,0x1.fffffffffffffp-2] = [0,0]_com <= [-0x1p-1074,0x1p-1074]_dac }
test g00.l0004 { roundTiesToEven<infsup<bin<53,11>>> [-0x1.fffffffffffffp-2,0] = [0,0]_com <= [-0x1p-1074,0x1p-1074]_dac }
test g00.l0005 { roundTiesToEven<infsup<bin<53,11>>> [0,0.5] = [0,0]_dac <= [-0x1p-1074,0x1.0000000000001p0]_def }
test g00.l0006 { roundTiesToEven<infsup<bin<53,11>>> [-0.5,0] = [0,0]_dac <= [-0x1.0000000000001p0,0x1p-1074]_def }
test g00.l0007 { roundTiesToEven<infsup<bin<53,11>>> [0.5,0.5] = [0,0]_dac <= [-0x1p-1074,0x1.0000000000001p0]_def }
test g00.l0008 { roundTiesToEven<infsup<bin<53,11>>> [-0.5,-0.5] = [0,0]_dac <= [-0x1.0000000000001p0,0x1p-1074]_def }
test g00.l0009 { roundTiesToEven<infsup<bin<53,11>>> [0.5,0x1.7ffffffffffffp0] = [0,1]_def <= [-0x1p-1074,0x1.0000000000001p1]_def }
test g00.l0010 { roundTiesToEven<infsup<bin<53,11>>> [-0x1.7ffffffffffffp0,-0.5] = [-1,0]_def <= [-0x1.0000000000001p1,0x1p-1074]_def }
test g00.l0011 { roundTiesToEven<infsup<bin<53,11>>> [0x1.0000000000001p-1,1.5] = [1,2]_def <= [-0x1p-1074,0x1.0000000000001p1]_def }
test g00.l0012 { roundTiesToEven<infsup<bin<53,11>>> [-1.5,-0x1.0000000000001p-1] = [-2,-1]_def <= [-0x1.0000000000001p1,0x1p-1074]_def }
test g00.l0013 { roundTiesToEven<infsup<bin<53,11>>> [0x1.0000000000001p-1,0x1.7ffffffffffffp0] = [1,1]_com <= [-0x1p-1074,0x1.0000000000001p1]_def }
test g00.l0014 { roundTiesToEven<infsup<bin<53,11>>> [-0x1.7ffffffffffffp0,-0x1.0000000000001p-1] = [-1,-1]_com <= [-0x1.0000000000001p1,0x1p-1074]_def }
test g00.l0015 { roundTiesToEven<infsup<bin<53,11>>> [1,1.5] = [1,2]_def <= [0x1.fffffffffffffp-1,0x1.0000000000001p1]_def }
test g00.l0016 { roundTiesToEven<infsup<bin<53,11>>> [-1.5,1] = [-2,1]_def <= [-0x1.0000000000001p1,0x1.0000000000001p0]_def }
test g00.l0017 { roundTiesToEven<infsup<bin<53,11>>> [1,0x1.7ffffffffffffp0] = [1,1]_com <= [0x1.fffffffffffffp-1,0x1.0000000000001p1]_def }
test g00.l0018 { roundTiesToEven<infsup<bin<53,11>>> [-0x1.7ffffffffffffp0,1] = [-1,1]_def <= [-0x1.0000000000001p1,0x1.0000000000001p0]_def }
test g00.l0019 { roundTiesToEven<infsup<bin<53,11>>> [4503599627370494.5,4503599627370495.5] = [4503599627370494,0x1p52]_def <= [4503599627370493.5,4503599627370497]_def }
test g00.l0020 { roundTiesToEven<infsup<bin<53,11>>> [-4503599627370495.5,-4503599627370494.5] = [-0x1p52,-4503599627370494]_def <= [-4503599627370497,-4503599627370493.5]_def }
test g00.l0021 { roundTiesToEven<infsup<bin<53,11>>> [4503599627370495,4503599627370495.5] = [4503599627370495,0x1p52]_def <= [4503599627370493.5,4503599627370497]_def }
test g00.l0022 { roundTiesToEven<infsup<bin<53,11>>> [-4503599627370495.5,-4503599627370495] = [-0x1p52,-4503599627370495]_def <= [-4503599627370497,-4503599627370493.5]_def }
test g00.l0023 { roundTiesToEven<infsup<bin<53,11>>> [4503599627370494.5,4503599627370495] = [4503599627370494,4503599627370495]_def <= [4503599627370493.5,4503599627370497]_def }
test g00.l0024 { roundTiesToEven<infsup<bin<53,11>>> [-4503599627370495,-4503599627370494.5] = [-4503599627370495,-4503599627370494]_def <= [-4503599627370497,-4503599627370493.5]_def }
test g00.l0025 { roundTiesToEven<infsup<bin<53,11>>> [4503599627370495,4503599627370495] = [4503599627370495,4503599627370495]_com <= [4503599627370493.5,4503599627370497]_def }
test g00.l0026 { roundTiesToEven<infsup<bin<53,11>>> [-4503599627370495,-4503599627370495] = [-4503599627370495,-4503599627370495]_com <= [-4503599627370497,-4503599627370493.5]_def }
test g00.l0027 { roundTiesToEven<infsup<bin<53,11>>> [4503599627370495.5,0x1p52] = [0x1p52,0x1p52]_dac <= [4503599627370494.5,4503599627370498]_def }
test g00.l0028 { roundTiesToEven<infsup<bin<53,11>>> [0x1p52,0x1p52] = [0x1p52,0x1p52]_com <= [4503599627370495.5,4503599627370498]_def }
test g00.l0029 { roundTiesToEven<infsup<bin<53,11>>> [-0x1p52,-0x1p52] = [-0x1p52,-0x1p52]_com <= [-4503599627370498,-4503599627370495.5]_def }
test g00.l0030 { roundTiesToEven<infsup<bin<53,11>>> [4503599627370497,4503599627370497] = [4503599627370497,4503599627370497]_com <= [4503599627370495.5,4503599627370499]_def }
test g00.l0031 { roundTiesToEven<infsup<bin<53,11>>> [-4503599627370497,-4503599627370497] = [-4503599627370497,-4503599627370497]_com <= [-4503599627370499,-4503599627370495.5]_def }
test g00.l0032 { roundTiesToEven<infsup<bin<53,11>>> [0x1.fffffffffffffp1023,0x1.fffffffffffffp1023] = [0x1.fffffffffffffp1023,0x1.fffffffffffffp1023]_com <= [0x1.ffffffffffffdp1023,Infinity]_def }
test g00.l0033 { roundTiesToEven<infsup<bin<53,11>>> [-0x1.fffffffffffffp1023,-0x1.fffffffffffffp1023] = [-0x1.fffffffffffffp1023,-0x1.fffffffffffffp1023]_com <= [-Infinity,-0x1.ffffffffffffdp1023]_def }
test g00.l0034 { roundTiesToEven<infsup<bin<53,11>>> [0x1.fffffffffffffp1023,Infinity] = [0x1.fffffffffffffp1023,Infinity]_def <= [0x1.ffffffffffffdp1023,Infinity]_def }
test g00.l0035 { roundTiesToEven<infsup<bin<53,11>>> [-Infinity,-0x1.fffffffffffffp1023] = [-Infinity,-0x1.fffffffffffffp1023]_def <= [-Infinity,-0x1.ffffffffffffdp1023]_def }
test g00.l0036 { roundTiesToAway<infsup<bin<53,11>>> [empty] = [empty]_trv <= [empty]_trv }
test g00.l0037 { roundTiesToAway<infsup<bin<53,11>>> [-Infinity,Infinity] = [-Infinity,Infinity]_def <= [-Infinity,Infinity]_def }
test g00.l0038 { roundTiesToAway<infsup<bin<53,11>>> [0,0] = [0,0]_com <= [-0x1p-1074,0x1p-1074]_com }
test g00.l0039 { roundTiesToAway<infsup<bin<53,11>>> [0,0x1.fffffffffffffp-2] = [0,0]_com <= [-0x1p-1074,0x1.0000000000001p0]_def }
test g00.l0040 { roundTiesToAway<infsup<bin<53,11>>> [-0x1.fffffffffffffp-2,0] = [0,0]_com <= [-0x1.0000000000001p0,0x1p-1074]_def }
test g00.l0041 { roundTiesToAway<infsup<bin<53,11>>> [0,0.5] = [0,1]_def <= [-0x1p-1074,0x1.0000000000001p0]_def }
test g00.l0042 { roundTiesToAway<infsup<bin<53,11>>> [-0.5,0] = [-1,0]_def <= [-0x1.0000000000001p0,0x1p-1074]_def }
test g00.l0043 { roundTiesToAway<infsup<bin<53,11>>> [0.5,0.5] = [1,1]_dac <= [-0x1p-1074,0x1.0000000000001p0]_def }
test g00.l0044 { roundTiesToAway<infsup<bin<53,11>>> [-0.5,-0.5] = [-1,-1]_dac <= [-0x1.0000000000001p0,0x1p-1074]_def }
test g00.l0045 { roundTiesToAway<infsup<bin<53,11>>> [0.5,0x1.7ffffffffffffp0] = [1,1]_dac <= [-0x1p-1074,0x1.0000000000001p1]_def }
test g00.l0046 { roundTiesToAway<infsup<bin<53,11>>> [-0x1.7ffffffffffffp0,-0.5] = [-1,-1]_dac <= [-0x1.0000000000001p1,0x1p-1074]_def }
test g00.l0047 { roundTiesToAway<infsup<bin<53,11>>> [0x1.0000000000001p-1,1.5] = [1,2]_def <= [0x1.fffffffffffffp-1,0x1.0000000000001p1]_def }
test g00.l0048 { roundTiesToAway<infsup<bin<53,11>>> [-1.5,-0x1.0000000000001p-1] = [-2,-1]_def <= [-0x1.0000000000001p1,-0x1.fffffffffffffp-1]_def }
test g00.l0049 { roundTiesToAway<infsup<bin<53,11>>> [0x1.0000000000001p-1,0x1.7ffffffffffffp0] = [1,1]_com <= [0x1.fffffffffffffp-1,0x1.0000000000001p1]_def }
test g00.l0050 { roundTiesToAway<infsup<bin<53,11>>> [-0x1.7ffffffffffffp0,-0x1.0000000000001p-1] = [-1,-1]_com <= [-0x1.0000000000001p1,-0x1.fffffffffffffp-1]_def }
test g00.l0051 { roundTiesToAway<infsup<bin<53,11>>> [1,1.5] = [1,2]_def <= [0x1.fffffffffffffp-1,0x1.0000000000001p1]_def }
test g00.l0052 { roundTiesToAway<infsup<bin<53,11>>> [-1.5,1] = [-2,1]_def <= [-0x1.0000000000001p1,0x1.0000000000001p0]_def }
test g00.l0053 { roundTiesToAway<infsup<bin<53,11>>> [1,0x1.7ffffffffffffp0] = [1,1]_com <= [0x1.fffffffffffffp-1,0x1.0000000000001p1]_def }
test g00.l0054 { roundTiesToAway<infsup<bin<53,11>>> [-0x1.7ffffffffffffp0,1] = [-1,1]_def <= [-0x1.0000000000001p1,0x1.0000000000001p0]_def }
test g00.l0055 { roundTiesToAway<infsup<bin<53,11>>> [4503599627370494.5,4503599627370495.5] = [4503599627370495,0x1p52]_def <= [4503599627370493.5,4503599627370497]_def }
test g00.l0056 { roundTiesToAway<infsup<bin<53,11>>> [-4503599627370495.5,-4503599627370494.5] = [-0x1p52,-4503599627370495]_def <= [-4503599627370497,-4503599627370493.5]_def }
test g00.l0057 { roundTiesToAway<infsup<bin<53,11>>> [4503599627370495,4503599627370495.5] = [4503599627370495,0x1p52]_def <= [4503599627370494.5,4503599627370497]_def }
test g00.l0058 { roundTiesToAway<infsup<bin<53,11>>> [-4503599627370495.5,-4503599627370495] = [-0x1p52,-4503599627370495]_def <= [-4503599627370497,-4503599627370494.5]_def }
test g00.l0059 { roundTiesToAway<infsup<bin<53,11>>> [4503599627370494.5,4503599627370495] = [4503599627370495,4503599627370495]_dac <= [4503599627370493.5,4503599627370497]_def }
test g00.l0060 { roundTiesToAway<infsup<bin<53,11>>> [-4503599627370495,-4503599627370494.5] = [-4503599627370495,-4503599627370495]_dac <= [-4503599627370497,-4503599627370493.5]_def }
test g00.l0061 { roundTiesToAway<infsup<bin<53,11>>> [4503599627370495,4503599627370495] = [4503599627370495,4503599627370495]_com <= [4503599627370494.5,4503599627370497]_def }
test g00.l0062 { roundTiesToAway<infsup<bin<53,11>>> [-4503599627370495,-4503599627370495] = [-4503599627370495,-4503599627370495]_com <= [-4503599627370497,-4503599627370494.5]_def }
test g00.l0063 { roundTiesToAway<infsup<bin<53,11>>> [4503599627370495.5,0x1p52] = [0x1p52,0x1p52]_dac <= [4503599627370494.5,4503599627370498]_def }
test g00.l0064 { roundTiesToAway<infsup<bin<53,11>>> [0x1p52,0x1p52] = [0x1p52,0x1p52]_com <= [4503599627370495.5,4503599627370498]_def }
test g00.l0065 { roundTiesToAway<infsup<bin<53,11>>> [-0x1p52,-0x1p52] = [-0x1p52,-0x1p52]_com <= [-4503599627370498,-4503599627370495.5]_def }
test g00.l0066 { roundTiesToAway<infsup<bin<53,11>>> [4503599627370497,4503599627370497] = [4503599627370497,4503599627370497]_com <= [4503599627370495.5,4503599627370499]_def }
test g00.l0067 { roundTiesToAway<infsup<bin<53,11>>> [-4503599627370497,-4503599627370497] = [-4503599627370497,-4503599627370497]_com <= [-4503599627370499,-4503599627370495.5]_def }
test g00.l0068 { roundTiesToAway<infsup<bin<53,11>>> [0x1.fffffffffffffp1023,0x1.fffffffffffffp1023] = [0x1.fffffffffffffp1023,0x1.fffffffffffffp1023]_com <= [0x1.ffffffffffffdp1023,Infinity]_def }
test g00.l0069 { roundTiesToAway<infsup<bin<53,11>>> [-0x1.fffffffffffffp1023,-0x1.fffffffffffffp1023] = [-0x1.fffffffffffffp1023,-0x1.fffffffffffffp1023]_com <= [-Infinity,-0x1.ffffffffffffdp1023]_def }
test g00.l0070 { roundTiesToAway<infsup<bin<53,11>>> [0x1.fffffffffffffp1023,Infinity] = [0x1.fffffffffffffp1023,Infinity]_def <= [0x1.ffffffffffffdp1023,Infinity]_def }
test g00.l0071 { roundTiesToAway<infsup<bin<53,11>>> [-Infinity,-0x1.fffffffffffffp1023] = [-Infinity,-0x1.fffffffffffffp1023]_def <= [-Infinity,-0x1.ffffffffffffdp1023]_def }
