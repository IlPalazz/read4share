-- Conditions Data

--  NW, // new
--  AN, // as new
--  GD, // good
--  FR, // fair
--  PR, // poor

-- New Book --> no underlining
INSERT INTO condition (cond_code, highl_underln, pen_underln, penc_underln) VALUES
                    ('NW', false, false, false);
-- Book As New
INSERT INTO condition (cond_code, highl_underln, pen_underln, penc_underln) VALUES
    ('AN', false, false, false);
INSERT INTO condition (cond_code, highl_underln, pen_underln, penc_underln) VALUES
    ('AN', false, false, true);
INSERT INTO condition (cond_code, highl_underln, pen_underln, penc_underln) VALUES
    ('AN', false, true, false);
INSERT INTO condition (cond_code, highl_underln, pen_underln, penc_underln) VALUES
    ('AN', false, true, true);
INSERT INTO condition (cond_code, highl_underln, pen_underln, penc_underln) VALUES
    ('AN', true, false, false);
INSERT INTO condition (cond_code, highl_underln, pen_underln, penc_underln) VALUES
    ('AN', true, false, true);
INSERT INTO condition (cond_code, highl_underln, pen_underln, penc_underln) VALUES
    ('AN', true, true, false);
INSERT INTO condition (cond_code, highl_underln, pen_underln, penc_underln) VALUES
    ('AN', true, true, true);

-- Book in Good conditions
INSERT INTO condition (cond_code, highl_underln, pen_underln, penc_underln) VALUES
    ('GD', false, false, false);
INSERT INTO condition (cond_code, highl_underln, pen_underln, penc_underln) VALUES
    ('GD', false, false, true);
INSERT INTO condition (cond_code, highl_underln, pen_underln, penc_underln) VALUES
    ('GD', false, true, false);
INSERT INTO condition (cond_code, highl_underln, pen_underln, penc_underln) VALUES
    ('GD', false, true, true);
INSERT INTO condition (cond_code, highl_underln, pen_underln, penc_underln) VALUES
    ('GD', true, false, false);
INSERT INTO condition (cond_code, highl_underln, pen_underln, penc_underln) VALUES
    ('GD', true, false, true);
INSERT INTO condition (cond_code, highl_underln, pen_underln, penc_underln) VALUES
    ('GD', true, true, false);
INSERT INTO condition (cond_code, highl_underln, pen_underln, penc_underln) VALUES
    ('GD', true, true, true);

-- Book in Fair conditions
INSERT INTO condition (cond_code, highl_underln, pen_underln, penc_underln) VALUES
    ('FR', false, false, false);
INSERT INTO condition (cond_code, highl_underln, pen_underln, penc_underln) VALUES
    ('FR', false, false, true);
INSERT INTO condition (cond_code, highl_underln, pen_underln, penc_underln) VALUES
    ('FR', false, true, false);
INSERT INTO condition (cond_code, highl_underln, pen_underln, penc_underln) VALUES
    ('FR', false, true, true);
INSERT INTO condition (cond_code, highl_underln, pen_underln, penc_underln) VALUES
    ('FR', true, false, false);
INSERT INTO condition (cond_code, highl_underln, pen_underln, penc_underln) VALUES
    ('FR', true, false, true);
INSERT INTO condition (cond_code, highl_underln, pen_underln, penc_underln) VALUES
    ('FR', true, true, false);
INSERT INTO condition (cond_code, highl_underln, pen_underln, penc_underln) VALUES
    ('FR', true, true, true);

-- Book in Poor conditions
INSERT INTO condition (cond_code, highl_underln, pen_underln, penc_underln) VALUES
    ('PR', false, false, false);
INSERT INTO condition (cond_code, highl_underln, pen_underln, penc_underln) VALUES
    ('PR', false, false, true);
INSERT INTO condition (cond_code, highl_underln, pen_underln, penc_underln) VALUES
    ('PR', false, true, false);
INSERT INTO condition (cond_code, highl_underln, pen_underln, penc_underln) VALUES
    ('PR', false, true, true);
INSERT INTO condition (cond_code, highl_underln, pen_underln, penc_underln) VALUES
    ('PR', true, false, false);
INSERT INTO condition (cond_code, highl_underln, pen_underln, penc_underln) VALUES
    ('PR', true, false, true);
INSERT INTO condition (cond_code, highl_underln, pen_underln, penc_underln) VALUES
    ('PR', true, true, false);
INSERT INTO condition (cond_code, highl_underln, pen_underln, penc_underln) VALUES
    ('PR', true, true, true);
