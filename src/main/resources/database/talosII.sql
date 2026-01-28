-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jan 28, 2026 at 06:44 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `talosII`
--

-- --------------------------------------------------------

--
-- Table structure for table `blueprint`
--

CREATE TABLE `blueprint` (
  `id` int(11) NOT NULL,
  `title` varchar(100) NOT NULL,
  `description` text DEFAULT NULL,
  `code_hash` varchar(500) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `blueprint`
--

INSERT INTO `blueprint` (`id`, `title`, `description`, `code_hash`, `created_at`) VALUES
(1, 'Buck Capsule (A)', 'You can bind the seperate Buckflower Loop into the farm, if necessary.\n\nBuild it on Originium Sciencepark, all upgrades except last Bus upgrade.', 'EFO0136uIO2uE1ae0i79', '2026-01-27 16:06:06'),
(2, 'Patrón de asalto nocturno', 'Estrategia para operaciones en condiciones de baja visibilidad', '7b8c9d0e1f2a', '2026-01-28 16:33:33');

-- --------------------------------------------------------

--
-- Table structure for table `element`
--

CREATE TABLE `element` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `element`
--

INSERT INTO `element` (`id`, `name`) VALUES
(2, 'Cryo'),
(3, 'Electric'),
(1, 'Heat'),
(5, 'Nature'),
(4, 'Physical');

-- --------------------------------------------------------

--
-- Table structure for table `gear`
--

CREATE TABLE `gear` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `image_url` varchar(500) DEFAULT NULL,
  `gear_type_id` int(11) NOT NULL,
  `gear_set_id` int(11) NOT NULL,
  `attribute_1` varchar(100) DEFAULT NULL,
  `attribute_2` varchar(100) DEFAULT NULL,
  `attribute_3` varchar(100) DEFAULT NULL,
  `def` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `gear`
--

INSERT INTO `gear` (`id`, `name`, `image_url`, `gear_type_id`, `gear_set_id`, `attribute_1`, `attribute_2`, `attribute_3`, `def`) VALUES
(1, 'Hot Work Exoskeleton', 'https://arknightsendfield.gg/wp-content/uploads/Hot-Work-Exo-Rig.png', 1, 1, 'Strength: 89', 'Agility: 58', 'Heat DMG Bonus: 11.50% / Nature DMG Bonus: 11.50%', 56),
(2, 'Hot Work Gauntlets', 'https://arknightsendfield.gg/wp-content/uploads/Hot-Work-Gauntlets.png', 2, 1, 'Intellect: 65', 'Strenght: 43', 'Heat DMG Bonus:  19.17% /  Nature DMG Bonus: 19.17%', 42),
(3, 'Hot Work Power Bank', 'https://arknightsendfield.gg/wp-content/uploads/Hot-Work-Power-Bank.png', 3, 1, 'Strength: 32', 'Agility: 21', 'Arts Intensity: 41', 21),
(4, 'Hot Work Pyrometer', 'https://arknightsendfield.gg/wp-content/uploads/Hot-Work-Pyrometer.png', 3, 1, 'Intellect: 41', 'Battle Skill DMG Bonus: 41.40%', '', 21);

-- --------------------------------------------------------

--
-- Table structure for table `gear_set`
--

CREATE TABLE `gear_set` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `bonus_description` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `gear_set`
--

INSERT INTO `gear_set` (`id`, `name`, `bonus_description`) VALUES
(1, 'Hot Work', '3-piece set effect: Wearer\'s Arts Intensity +30. After the wearer applies Combustion, the wearer gains Heat DMG +50% for 10s. After the wearer applies Corrosion, the wearer gains Nature DMG +50% for 10s. The aforementioned effects cannot stack.');

-- --------------------------------------------------------

--
-- Table structure for table `gear_type`
--

CREATE TABLE `gear_type` (
  `id` int(11) NOT NULL,
  `name` varchar(20) NOT NULL
) ;

--
-- Dumping data for table `gear_type`
--

INSERT INTO `gear_type` (`id`, `name`) VALUES
(1, 'Armor'),
(2, 'Gloves'),
(3, 'Kit');

-- --------------------------------------------------------

--
-- Table structure for table `operator`
--

CREATE TABLE `operator` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `rarity_id` int(11) NOT NULL,
  `image_url` varchar(500) DEFAULT NULL,
  `element_id` int(11) NOT NULL,
  `weapon_type_id` int(11) NOT NULL,
  `operator_class_id` int(11) NOT NULL,
  `strength` int(11) NOT NULL,
  `agility` int(11) NOT NULL,
  `intellect` int(11) NOT NULL,
  `will` int(11) NOT NULL,
  `basic_attack` varchar(100) NOT NULL,
  `basic_attack_desc` text NOT NULL,
  `battle_skill` varchar(100) NOT NULL,
  `battle_skill_desc` text NOT NULL,
  `battle_skill_sp_cost` int(11) NOT NULL,
  `combo_skill` varchar(100) NOT NULL,
  `combo_skill_desc` text NOT NULL,
  `combo_skill_cooldown` int(11) NOT NULL,
  `ultimate` varchar(100) NOT NULL,
  `ultimate_desc` text NOT NULL,
  `ultimate_energy_cost` int(11) NOT NULL,
  `base_talent_1` text NOT NULL,
  `base_talent_2` text NOT NULL,
  `combat_talent_1` text NOT NULL,
  `combat_talent_2` text NOT NULL,
  `p1` text DEFAULT NULL,
  `p1_effect` text DEFAULT NULL,
  `p2` text DEFAULT NULL,
  `p2_effect` text DEFAULT NULL,
  `p3` text DEFAULT NULL,
  `p3_effect` text DEFAULT NULL,
  `p4` text DEFAULT NULL,
  `p4_effect` text DEFAULT NULL,
  `p5` text DEFAULT NULL,
  `p5_effect` text DEFAULT NULL,
  `concept_art_1` varchar(500) DEFAULT NULL,
  `concept_art_2` varchar(500) DEFAULT NULL,
  `concept_art_3` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `operator`
--

INSERT INTO `operator` (`id`, `name`, `rarity_id`, `image_url`, `element_id`, `weapon_type_id`, `operator_class_id`, `strength`, `agility`, `intellect`, `will`, `basic_attack`, `basic_attack_desc`, `battle_skill`, `battle_skill_desc`, `battle_skill_sp_cost`, `combo_skill`, `combo_skill_desc`, `combo_skill_cooldown`, `ultimate`, `ultimate_desc`, `ultimate_energy_cost`, `base_talent_1`, `base_talent_2`, `combat_talent_1`, `combat_talent_2`, `p1`, `p1_effect`, `p2`, `p2_effect`, `p3`, `p3_effect`, `p4`, `p4_effect`, `p5`, `p5_effect`, `concept_art_1`, `concept_art_2`, `concept_art_3`) VALUES
(1, 'Laevatain', 3, '/images/splash/Laevatain_Splash_Art.png', 1, 1, 4, 121, 99, 177, 89, 'Flaming Cinders', 'An attack with up to 5 sequences that deals Heat DMG. As the controlled operator, Final Strike also deals 18 Stagger.\r\nDIVE ATTACK:\r\n\r\nBasic attack performed in mid-air becomes a dive attack that deals Heat DMG to nearby enemies.\r\nFINISHER:\r\n\r\nBasic attack performed near a Staggered enemy becomes a finisher attack that deals massive Heat DMG and recovers some SP.', 'Smouldering Fire', 'Summons a Magma Fragment to continuously attack enemies and deal Heat DMG. Hitting the enemy grants 1 stack of Melting Flame.\r\nIf Laevatain already has 4 stack(s) of Melting Flame when casting the skill, then consume all the stacks and perform 1 additional attack that deals Heat DMG and forcibly trigger temporary Combustion to all enemies in a large area.\r\nWhen the additional attack hits the enemy, restore additional Ultimate Energy.\r\nBattle skill effects are enhanced while Laevatain\'s ultimate is active.', 100, 'Seethe', 'Fire erupts beneath the feet of any enemy with Combustion or Corrosion, dealing Heat DMG to them.\r\nIf the skill hits the enemy, Laevatain gains 1 stack of Melting Flame and further gains Ultimate Energy per enemy hit.\r\n\r\nTrigger: When an enemy suffers Combustion or Corrosion.', 9, 'Twilight', 'Laevatain summons her Sviga Lævi and becomes the controlled operator.\r\nFor a certain duration, her basic attacks (BATK) are enhanced and the Sviga Lævi strikes together with Laevatain, with each attack dealing Heat DMG. BATK sequence 3 also applies Heat Infliction.', 300, 'Assign to Manufacturing Cabin to grant operator EXP material production efficiency +20/30%.', 'Assign to Manufacturing Cabin to slow Mood Drop of all operators in it by 14/18%.', 'When the controlled operator\'s Final Strike or Finisher hits the enemy, Laevatain absorbs Heat Infliction from nearby enemies.\r\nEvery stack of Heat Infliction absorbed gives Laevatain 1 stack of Melting Flame (max stacks: 4). At 4 stacks, DMG dealt by Laevatain ignores 10/15/20 Heat Resistance of the enemy for 20s.\r\nLaevatain also absorbs Heat Infliction from enemies defeated nearby.', 'When HP drops below 40%, gain 90% Protection and restore 5% Max HP per second for 4/8s. This effect triggers once every 120s.', 'Heart of Melting Flame', 'Battle skill Smouldering Fire improved: Additional attack multiplier is increased to 1.2 times the original, and scoring a hit returns 20 SP.', 'Pursuit of Memories', 'Intellect +20, Basic Attack DMG Dealt +15%.', 'Fragments from the Past', 'Battle skill Smouldering Fire improved: Duration of the Combustion applied by the skill is increased by 50%. DMG of the Combustion applied by the skills is increased to 1.5 times the original.', 'Ice Cream Furnace', 'Ultimate Twilight improved: Ultimate Energy cost -15%.', 'Proof of Existence', 'Ultimate Twilight improved: Enhanced basic attack DMG multiplier is increased to 1.2 times the original; during the ultimate, every enemy defeated by Laevatain extends ultimate duration by +1s (max: +7s).', '', '', ''),
(2, 'Ardelia', 3, '/images/splash/Ardelia_Splash_Art.png', 5, 3, 5, 112, 93, 145, 118, 'Rocky Whispers', 'BASIC ATTACK:\r\n\r\nAn attack with up to 4 sequences that deals Nature DMG. As the controlled operator, Final Strike also deals 18 Stagger.\r\nDIVE ATTACK:\r\n\r\nBasic attack performed in mid-air becomes a dive attack that deals Nature DMG to nearby enemies.\r\nFINISHER:\r\n\r\nBasic attack performed near a Staggered enemy becomes a finisher attack that deals massive Nature DMG and recovers some SP.', 'Dolly Rush', 'Hops on Mr. Dolly and rams the target to deal Nature DMG. If the target has Corrosion, then consume the Corrosion and apply Physical Susceptibility and Arts Susceptibility to the target.', 100, 'Eruption Column', 'Launches a homing Volcanic Cloud at a target enemy that deals Nature DMG when close enough to the target. The Volcanic Cloud explodes after a short delay, dealing half of the Nature DMG and forcibly applying temporary Corrosion to nearby enemies.\r\n\r\nTrigger: When the controlled operator performs a Final Strike on an enemy with no stacks of Vulnerability or Arts Infliction.', 17, 'Wooly Party', 'Ardelia enters a mobile channeling state and summons the aid of Mr. Dolly. Multiple copies of Mr. Dolly are thrown in random directions. Each copy deals Nature DMG. Each enemy can only take 1 damaging hit every 0.3s.', 90, 'Assign to Reception Room to grant operator clue collecting efficiency +20/30%.', 'Assign to Reception Room to slow Mood Drop of all operators in it by 14/18%.', 'The battle skill Dolly Rush creates 3 Shadows of Mr. Dolly after hitting the enemy. The copies of Mr. Dolly scattered by the ultimate Wooly Party also has a 10% chance to create Shadows of Mr. Dolly when they fall to the ground.\r\nWhen the controlled operator touches a Shadow of Mr. Dolly, Ardelia restores the said operator\'s HP by [45 + Will×0.38]/[63 + Will×0.53]/[90 + Will×0.75].\r\nIf the controlled operator is already at max HP, then restore the HP of the teammate with lowest percentage HP. Shadows of Mr. Dolly lasts for 10s and up to 10 can exist in the battlefield.', 'Battle skill Dolly Rush improved: Triggering the additional effect while an enemy with Corrosion is nearby immediately casts the battle skill again. This effect only triggers once per active battle skill casting.', 'Dolly Paradise', 'Battle skill Dolly Rush improved: Consuming Corrosion now applies Physical Susceptibility and Arts Susceptibility with effects +8%.', 'Game Rewards', 'Talent Friendly Presence improved: When the controlled operator touches the Shadow of Mr. Dolly, Ardelia also treats another allied operator with the lowest percentage HP with half of the treatment effects.', 'Explosive Eruption', 'Ultimate Wooly Party improved: Duration +1s; chance to create Shadow of Mr. Dolly is increased to 1.2 times the original.', 'Rock Blossom', 'Ultimate Wooly Party improved: Ultimate Energy cost -15%.', 'Volcanic Steam', 'Combo skill Eruption Column improved: Length of cooldown -2s; DMG multiplier is increased to 1.2 times the original; duration of Corrosion applied +4s.', '', '', ''),
(3, 'Antal', 1, '/images/splash/Antal_Splash_Art.png', 3, 3, 5, 129, 86, 165, 82, 'Exchange Current', 'BASIC ATTACK:\r\n\r\nAn attack with up to 4 sequences that deals Electric DMG. As the controlled operator, Final Strike also deals 15 Stagger.\r\nDIVE ATTACK:\r\n\r\nBasic attack performed in mid-air becomes a dive attack that deals Electric DMG to nearby enemies.\r\nFINISHER:\r\n\r\nBasic attack performed near a Staggered enemy becomes a finisher attack that deals massive Electric DMG and recovers some SP.', 'Specified Research Subject', 'Applies Focus with a long duration on the enemy and deals Electric DMG. An enemy with an active Focus also suffers Electric Susceptibility and Heat Susceptibility. Focus can only be applied to 1 enemy at any given time.', 100, 'EMP Test Site', 'Triggers 1 energy explosion on the enemy that deals Electric DMG and applies another stack of the same Physical Status or Arts Infliction.\r\n\r\nTrigger: When an enemy with active Focus suffers a Physical Status or Arts Infliction.', 24, 'Overclocked Moment', 'Applies temporary Electric Amp and Heat Amp to the entire team.', 100, 'Assign to Manufacturing Cabin to grant weapon EXP material production efficiency +10/20%.', 'Assign to Growth Chamber to slow Mood Drop of all operators in it by 14/18%.', 'After an Amped teammate deals Skill DMG, Antal restores the said teammate\'s HP by [72 + Strength×0.6]/[108 + Strength×0.9]. This HP restoring effect triggers 1 time every 30s for each operator.', 'Gains 30% chance of Physical DMG immunity and restores HP of self by [27 + Strength×0.23]/[45 + Strength×0.38].', 'Arts Talent', 'Ultimate Overclocked Moment improved: Electric Amp and Heat Amp effects are increased to 1.1 times the original.', 'Improved Automation', 'Ultimate Overclocked Moment improved: Ultimate Energy cost -10%.', 'Applied Originium Theory', 'When an enemy with an active Focus debuff is defeated, returns 15 SP.', 'Granny\'s Reminder', 'Intellect +10, Max HP +10%.', 'High Specs Tech Tester', 'Applying Focus on the same target for 20s increases Electric Susceptibility and Heat Susceptibility effects by 4%.', '', '', ''),
(4, 'Wulfgard', 2, '/images/splash/Wulfgard_Splash_Art.png', 1, 4, 4, 161, 95, 92, 111, 'Rapid Fire Akimbo', 'BASIC ATTACK:\r\n\r\nAn attack with up to 4 sequences that deals Heat DMG. As the controlled operator, Final Strike also deals 18 Stagger.\r\nDIVE ATTACK:\r\n\r\nBasic attack performed in mid-air becomes a dive attack that deals Heat DMG to nearby enemies.\r\nFINISHER:\r\n\r\nBasic attack performed near a Staggered enemy becomes a finisher attack that deals massive Heat DMG and recovers some SP.', 'Thermite Tracers', 'Fires multiple shots at the target that deal some Heat DMG. The final shot also applies Heat Infliction. If the target has active Combustion or Electrification, do not apply Heat Infliction but instead consume the Arts Reaction to fire an additional shot that deals massive Heat DMG.\r\n', 100, 'Frag Grenade·β', 'Throws a frag grenade at the target\'s location that explodes upon hitting the ground, dealing Heat DMG and Heat Infliction to nearby enemies.\r\n\r\nTrigger: When an Arts Infliction is applied to an enemy', 19, 'Wolven Fury', 'Fire a rapid barrage of shots and unleashes the Wolven Fury to attack nearby enemies, dealing 5 hits of Heat DMG and forcibly applying Combustion.', 90, 'Assign to Manufacturing Cabin to grant operator EXP material production efficiency +10/20%.', 'Assign to Growth Chamber to grant rare mineral growth rate +20/30%.', 'Whenever Wulfgard applies Combustion, he gains Scorching Fangs for 10s. This effect cannot stack.\r\nScorching Fangs: While active, Wulfgard gains Heat DMG Dealt +20/30%.', 'Whenever the battle skill Thermite Tracers successfully consumes an Arts Reaction, return 5/10 SP.', 'Lone Wolf', 'Strength +15, Agility +15.', 'Firearm Mods', 'Talent Code of Restraint improved: Returns 10 additional SP.', 'Hunting Hour', 'While Scorching Fangs is active, triggering the battle skill\'s additional effects immediately resets the Scorching Fangs duration and grants other teammates Scorching Fangs with 50% of the base effects.', 'Will of the Pack', 'Ultimate Wolven Fury improved: Ultimate Energy cost -15%.', 'Natural Predator', 'Casting the ultimate Wolven Fury immediately resets the cooldown of the combo skill Frag Grenade·β.', '', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `operator_class`
--

CREATE TABLE `operator_class` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `operator_class`
--

INSERT INTO `operator_class` (`id`, `name`) VALUES
(4, 'Caster'),
(3, 'Defender'),
(2, 'Guard'),
(6, 'Striker'),
(5, 'Supporter'),
(1, 'Vanguard');

-- --------------------------------------------------------

--
-- Table structure for table `rarity`
--

CREATE TABLE `rarity` (
  `id` int(11) NOT NULL,
  `stars` int(11) NOT NULL
) ;

--
-- Dumping data for table `rarity`
--

INSERT INTO `rarity` (`id`, `stars`) VALUES
(1, 4),
(2, 5),
(3, 6);

-- --------------------------------------------------------

--
-- Table structure for table `team`
--

CREATE TABLE `team` (
  `id` int(11) NOT NULL,
  `team_name` varchar(100) NOT NULL,
  `description` text DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `team`
--

INSERT INTO `team` (`id`, `team_name`, `description`, `created_at`) VALUES
(4, 'Heat team', 'Team of heat damage', '2026-01-28 16:29:33');

-- --------------------------------------------------------

--
-- Table structure for table `team_operator`
--

CREATE TABLE `team_operator` (
  `id` bigint(20) NOT NULL,
  `team_id` int(11) NOT NULL,
  `operator_id` int(11) NOT NULL,
  `position` int(11) NOT NULL
) ;

--
-- Dumping data for table `team_operator`
--

INSERT INTO `team_operator` (`id`, `team_id`, `operator_id`, `position`) VALUES
(1, 4, 1, 0),
(2, 4, 2, 1),
(3, 4, 3, 2),
(4, 4, 4, 3);

-- --------------------------------------------------------

--
-- Table structure for table `team_operator_equipment`
--

CREATE TABLE `team_operator_equipment` (
  `id` int(11) NOT NULL,
  `team_id` int(11) NOT NULL,
  `operator_position` int(11) NOT NULL,
  `weapon_id` int(11) NOT NULL,
  `armor_gear_id` int(11) NOT NULL,
  `gloves_gear_id` int(11) NOT NULL,
  `kit1_gear_id` int(11) NOT NULL,
  `kit2_gear_id` int(11) NOT NULL
) ;

--
-- Dumping data for table `team_operator_equipment`
--

INSERT INTO `team_operator_equipment` (`id`, `team_id`, `operator_position`, `weapon_id`, `armor_gear_id`, `gloves_gear_id`, `kit1_gear_id`, `kit2_gear_id`) VALUES
(1, 4, 0, 2, 1, 2, 3, 4),
(2, 4, 1, 5, 1, 2, 3, 4),
(3, 4, 2, 6, 1, 2, 3, 4),
(4, 4, 3, 4, 1, 2, 3, 4);

-- --------------------------------------------------------

--
-- Table structure for table `weapon`
--

CREATE TABLE `weapon` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `rarity_id` int(11) NOT NULL,
  `image_url` varchar(500) DEFAULT NULL,
  `weapon_type_id` int(11) NOT NULL,
  `base_atk` int(11) NOT NULL,
  `stat_1` varchar(100) DEFAULT NULL,
  `stat_2` varchar(100) DEFAULT NULL,
  `passive` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `weapon`
--

INSERT INTO `weapon` (`id`, `name`, `rarity_id`, `image_url`, `weapon_type_id`, `base_atk`, `stat_1`, `stat_2`, `passive`) VALUES
(2, 'Forgeborn Scathe', 3, 'https://endfield.wiki.gg/images/Forgeborn_Scathe_icon.png?e338db', 1, 510, 'Intellect: +156', 'Attack: +39.00%', 'Heat DMG Bonus: +25.60%\r\nAfter the wielder casts an Ultimate, the wielder gains Basic Attack DMG dealt +120% for 20s. Effects of the same name cannot stack.'),
(4, 'Clannibal', 3, 'https://endfield.wiki.gg/images/Clannibal_icon.png?cc0dcd', 4, 490, 'Main Attribute: +132', 'Arts DMG Bonus: +43.30%', 'Arts DMG Bonus: +19.20%\r\nAfter the wielder consumes an Arts Reaction, target enemy suffers Arts DMG taken +16% (for the specified element) for 15s. Effect only triggers once every 25s.'),
(5, 'Dreams of the Starry Beach', 3, 'https://endfield.wiki.gg/images/Dreams_of_the_Starry_Beach_icon.png?875f3e', 3, 495, 'Intellect: +156', 'Treatment Bonus: +46.40%', 'Sec. Attribute: +25.60%\r\nAfter the wielder consumes Corrosion, target enemy suffers Arts DMG taken +16% for 25s. Effects of the same name cannot stack.'),
(6, 'OBJ Arts Identifier', 2, 'https://endfield.wiki.gg/images/OBJ_Arts_Identifier_icon.png?dde51c', 3, 411, 'Intellect: +124', 'Arts Intensity: +62', 'Max HP: +28.00%\r\nAfter the wielder applies Arts Burst or Physical Status with their own Combo Skill, the entire team gains Heat DMG dealt and Electric DMG dealt +22.4% for 15s. Effects of the same name cannot stack.');

-- --------------------------------------------------------

--
-- Table structure for table `weapon_type`
--

CREATE TABLE `weapon_type` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `weapon_type`
--

INSERT INTO `weapon_type` (`id`, `name`) VALUES
(3, 'Arts Unit'),
(5, 'Greatsword'),
(4, 'Handcannon'),
(2, 'Polearm'),
(1, 'Sword');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `blueprint`
--
ALTER TABLE `blueprint`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idx_blueprint_code` (`code_hash`);

--
-- Indexes for table `element`
--
ALTER TABLE `element`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`);

--
-- Indexes for table `gear`
--
ALTER TABLE `gear`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`,`gear_type_id`,`gear_set_id`),
  ADD KEY `fk_gear_set` (`gear_set_id`),
  ADD KEY `idx_gear_type_set` (`gear_type_id`,`gear_set_id`);

--
-- Indexes for table `gear_set`
--
ALTER TABLE `gear_set`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`);

--
-- Indexes for table `gear_type`
--
ALTER TABLE `gear_type`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`);

--
-- Indexes for table `operator`
--
ALTER TABLE `operator`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`),
  ADD KEY `fk_operator_rarity` (`rarity_id`),
  ADD KEY `fk_operator_element` (`element_id`),
  ADD KEY `fk_operator_class` (`operator_class_id`),
  ADD KEY `idx_operator_weapon_type` (`weapon_type_id`);

--
-- Indexes for table `operator_class`
--
ALTER TABLE `operator_class`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`);

--
-- Indexes for table `rarity`
--
ALTER TABLE `rarity`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `stars` (`stars`);

--
-- Indexes for table `team`
--
ALTER TABLE `team`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idx_team_created` (`created_at`);

--
-- Indexes for table `team_operator`
--
ALTER TABLE `team_operator`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `team_id` (`team_id`,`operator_id`),
  ADD UNIQUE KEY `uk_team_position` (`team_id`,`position`),
  ADD UNIQUE KEY `uk_team_operator` (`team_id`,`operator_id`),
  ADD KEY `idx_team_operator_team` (`team_id`),
  ADD KEY `idx_team_operator_operator` (`operator_id`);

--
-- Indexes for table `team_operator_equipment`
--
ALTER TABLE `team_operator_equipment`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `unique_team_position` (`team_id`,`operator_position`),
  ADD KEY `fk_toe_armor` (`armor_gear_id`),
  ADD KEY `fk_toe_gloves` (`gloves_gear_id`),
  ADD KEY `fk_toe_kit1` (`kit1_gear_id`),
  ADD KEY `fk_toe_kit2` (`kit2_gear_id`),
  ADD KEY `idx_toe_team` (`team_id`),
  ADD KEY `idx_toe_weapon` (`weapon_id`);

--
-- Indexes for table `weapon`
--
ALTER TABLE `weapon`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`),
  ADD KEY `fk_weapon_rarity` (`rarity_id`),
  ADD KEY `fk_weapon_type` (`weapon_type_id`);

--
-- Indexes for table `weapon_type`
--
ALTER TABLE `weapon_type`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `blueprint`
--
ALTER TABLE `blueprint`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `element`
--
ALTER TABLE `element`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `gear`
--
ALTER TABLE `gear`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `gear_set`
--
ALTER TABLE `gear_set`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `gear_type`
--
ALTER TABLE `gear_type`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `operator`
--
ALTER TABLE `operator`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `operator_class`
--
ALTER TABLE `operator_class`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `rarity`
--
ALTER TABLE `rarity`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `team`
--
ALTER TABLE `team`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `team_operator`
--
ALTER TABLE `team_operator`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `team_operator_equipment`
--
ALTER TABLE `team_operator_equipment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `weapon`
--
ALTER TABLE `weapon`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `weapon_type`
--
ALTER TABLE `weapon_type`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `gear`
--
ALTER TABLE `gear`
  ADD CONSTRAINT `fk_gear_set` FOREIGN KEY (`gear_set_id`) REFERENCES `gear_set` (`id`),
  ADD CONSTRAINT `fk_gear_type` FOREIGN KEY (`gear_type_id`) REFERENCES `gear_type` (`id`);

--
-- Constraints for table `operator`
--
ALTER TABLE `operator`
  ADD CONSTRAINT `fk_operator_class` FOREIGN KEY (`operator_class_id`) REFERENCES `operator_class` (`id`),
  ADD CONSTRAINT `fk_operator_element` FOREIGN KEY (`element_id`) REFERENCES `element` (`id`),
  ADD CONSTRAINT `fk_operator_rarity` FOREIGN KEY (`rarity_id`) REFERENCES `rarity` (`id`),
  ADD CONSTRAINT `fk_operator_weapon_type` FOREIGN KEY (`weapon_type_id`) REFERENCES `weapon_type` (`id`);

--
-- Constraints for table `team_operator`
--
ALTER TABLE `team_operator`
  ADD CONSTRAINT `fk_team_operator_operator` FOREIGN KEY (`operator_id`) REFERENCES `operator` (`id`),
  ADD CONSTRAINT `fk_team_operator_team` FOREIGN KEY (`team_id`) REFERENCES `team` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `team_operator_equipment`
--
ALTER TABLE `team_operator_equipment`
  ADD CONSTRAINT `fk_toe_armor` FOREIGN KEY (`armor_gear_id`) REFERENCES `gear` (`id`),
  ADD CONSTRAINT `fk_toe_gloves` FOREIGN KEY (`gloves_gear_id`) REFERENCES `gear` (`id`),
  ADD CONSTRAINT `fk_toe_kit1` FOREIGN KEY (`kit1_gear_id`) REFERENCES `gear` (`id`),
  ADD CONSTRAINT `fk_toe_kit2` FOREIGN KEY (`kit2_gear_id`) REFERENCES `gear` (`id`),
  ADD CONSTRAINT `fk_toe_team` FOREIGN KEY (`team_id`) REFERENCES `team` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `fk_toe_team_operator` FOREIGN KEY (`team_id`,`operator_position`) REFERENCES `team_operator` (`team_id`, `position`) ON DELETE CASCADE,
  ADD CONSTRAINT `fk_toe_weapon` FOREIGN KEY (`weapon_id`) REFERENCES `weapon` (`id`);

--
-- Constraints for table `weapon`
--
ALTER TABLE `weapon`
  ADD CONSTRAINT `fk_weapon_rarity` FOREIGN KEY (`rarity_id`) REFERENCES `rarity` (`id`),
  ADD CONSTRAINT `fk_weapon_type` FOREIGN KEY (`weapon_type_id`) REFERENCES `weapon_type` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
